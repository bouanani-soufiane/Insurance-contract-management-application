package ma.yc.insurance.infrastructure.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.insurance.application.dto.request.CarInsuranceRequestDto;
import ma.yc.insurance.application.dto.request.HealthInsuranceRequestDto;
import ma.yc.insurance.application.dto.request.HomeInsuranceRequestDto;
import ma.yc.insurance.application.service.InsuranceService;
import ma.yc.insurance.domain.enums.PropertyType;
import ma.yc.insurance.domain.enums.RiskZone;
import ma.yc.insurance.domain.valueObject.Address;
import ma.yc.insurance.domain.valueObject.DriverHistory;
import ma.yc.insurance.domain.valueObject.SecuritySystem;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/insurance")
@RequiredArgsConstructor
@Slf4j
public class InsuranceController {

    private final InsuranceService insuranceService;

    @GetMapping("/car")
    public ModelAndView showCarInsuranceForm () {
        ModelAndView modelAndView = new ModelAndView("insurance/automobile");
        modelAndView.addObject("carInsuranceRequestDto", new CarInsuranceRequestDto(0, "", "", null, new DriverHistory(0, 0, 0)));
        return modelAndView;
    }

    @PostMapping("/car")
    public ModelAndView saveCarInsurance ( @Valid @ModelAttribute CarInsuranceRequestDto carInsuranceRequestDto, BindingResult bindingResult, RedirectAttributes redirectAttributes ) {
        if (bindingResult.hasErrors()) {
            return handleErrors("insurance/automobile", "carInsuranceRequestDto", carInsuranceRequestDto, bindingResult);
        }

        try {
            insuranceService.save(carInsuranceRequestDto);
            redirectAttributes.addFlashAttribute("message", "Insurance request submitted successfully!");
            return new ModelAndView("redirect:/insurance/car");
        } catch (Exception e) {
            return handleException("insurance/automobile", "carInsuranceRequestDto", carInsuranceRequestDto, e);
        }
    }

    @GetMapping("/health")
    public ModelAndView showHealthInsuranceForm () {
        ModelAndView modelAndView = new ModelAndView("insurance/health");
        modelAndView.addObject("healthInsuranceRequestDto", new HealthInsuranceRequestDto(0, true, null));
        return modelAndView;
    }

    @PostMapping("/health")
    public ModelAndView saveHealthInsurance ( @Valid @ModelAttribute HealthInsuranceRequestDto healthInsuranceRequestDto, BindingResult bindingResult, RedirectAttributes redirectAttributes ) {
        if (bindingResult.hasErrors()) {
            return handleErrors("insurance/health", "healthInsuranceRequestDto", healthInsuranceRequestDto, bindingResult);
        }

        try {
            insuranceService.save(healthInsuranceRequestDto);
            redirectAttributes.addFlashAttribute("message", "Insurance request submitted successfully!");
            return new ModelAndView("redirect:/insurance/health");
        } catch (Exception e) {
            return handleException("insurance/health", "healthInsuranceRequestDto", healthInsuranceRequestDto, e);
        }
    }

    @GetMapping("/home")
    public ModelAndView showHomeInsuranceForm () {
        ModelAndView modelAndView = new ModelAndView("insurance/home");
        HomeInsuranceRequestDto dto = new HomeInsuranceRequestDto(0, null, new Address("", "", RiskZone.LOW_RISK), new SecuritySystem(false, false));
        modelAndView.addObject("homeInsuranceRequestDto", dto);
        return modelAndView;
    }

    @PostMapping("/home")
    public ModelAndView saveHomeInsurance ( @RequestParam("propertyValue") double propertyValue, @RequestParam("propertyType") PropertyType propertyType, @RequestParam("street") String street, @RequestParam("city") String city, @RequestParam("riskZone") RiskZone riskZone, @RequestParam("hasAlarm") boolean hasAlarm, @RequestParam("hasCameras") boolean hasCameras, RedirectAttributes redirectAttributes ) {

        Address address = new Address(street, city, riskZone);
        SecuritySystem securitySystem = new SecuritySystem(hasAlarm, hasCameras);
        HomeInsuranceRequestDto homeInsuranceRequestDto = new HomeInsuranceRequestDto(propertyValue, propertyType, address, securitySystem);

        try {
            insuranceService.save(homeInsuranceRequestDto);
            redirectAttributes.addFlashAttribute("message", "Insurance request submitted successfully!");
            return new ModelAndView("redirect:/insurance/home");
        } catch (Exception e) {
            return handleException("insurance/home", "homeInsuranceRequestDto", homeInsuranceRequestDto, e);
        }
    }

    private ModelAndView handleErrors ( String viewName, String dtoName, Object dto, BindingResult bindingResult ) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(dtoName, dto);
        modelAndView.addObject("errors", bindingResult.getAllErrors());
        return modelAndView;
    }

    private ModelAndView handleException ( String viewName, String dtoName, Object dto, Exception e ) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(dtoName, dto);
        modelAndView.addObject("error", "Failed to save insurance request: " + e.getMessage());
        return modelAndView;
    }
}
