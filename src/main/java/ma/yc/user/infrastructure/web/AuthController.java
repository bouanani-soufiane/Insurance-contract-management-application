package ma.yc.user.infrastructure.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.yc.user.application.dto.request.UserRequestDto;
import ma.yc.user.application.service.AuthService;
import ma.yc.user.infrastructure.mapping.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService service;
    private final UserMapper mapper;

    @GetMapping("/")
    public ModelAndView home ( Model model ) {
        return new ModelAndView("home");
    }

    @GetMapping("/signup")
    public ModelAndView register () {
        return new ModelAndView("auth/signup");
    }

    @PostMapping("/signup")
    public RedirectView register ( @Valid @ModelAttribute("userRequestDto") UserRequestDto dto, BindingResult result, RedirectAttributes redirectAttributes ) {
        if (result.hasErrors()) {
            System.out.println("error validation");
            return new RedirectView("/signup", true);
        }
        try {
            service.signup(dto);
            redirectAttributes.addFlashAttribute("success", "user registered with success");
            return new RedirectView("/signup", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "error registering user  ");
            return new RedirectView("/signup", true);
        }

    }

    @GetMapping("/login")
    public ModelAndView login () {
        return new ModelAndView("auth/login");
    }

    @PostMapping("/login")
    public RedirectView login ( @ModelAttribute("userRequestDto") UserRequestDto dto ) {
        service.login(dto);
        return new RedirectView("/login", true);
    }
}