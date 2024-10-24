package ma.yc.insurance.infrastructure.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.insurance.application.dto.request.CarInsuranceRequestDto;
import ma.yc.insurance.application.service.InsuranceService;
import ma.yc.insurance.domain.valueObject.DriverHistory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/insurance")
@RequiredArgsConstructor
@Slf4j
public class InsuranceController {
    private final InsuranceService insuranceService;

    @GetMapping("/carinsurance")
    public ModelAndView automobile () {
        ModelAndView modelAndView = new ModelAndView("insurance/automobile");
        modelAndView.addObject("carinsurancerequestdto", new CarInsuranceRequestDto(
                0, "", "", null, new DriverHistory(0, 0, 0)
        ));
        return modelAndView;
    }

    @PostMapping("/carinsurance")
    public ModelAndView saveCarInsurance (
            @Valid @ModelAttribute CarInsuranceRequestDto carInsuranceRequestDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes ) {

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("insurance/automobile");
            modelAndView.addObject("carinsurancerequestdto", carInsuranceRequestDto);
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }

        try {
            insuranceService.save(carInsuranceRequestDto);
            redirectAttributes.addFlashAttribute("message", "Insurance request submitted successfully!");
            return new ModelAndView("redirect:/insurance/carinsurance");
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("insurance/automobile");
            modelAndView.addObject("carinsurancerequestdto", carInsuranceRequestDto);
            modelAndView.addObject("error", "Failed to save insurance request: " + e.getMessage());
            return modelAndView;
        }
    }
}