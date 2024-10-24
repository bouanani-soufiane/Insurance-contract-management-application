package ma.yc.user.infrastructure.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.yc.common.domain.exception.UserAlreadyExistsException;
import ma.yc.user.application.dto.request.UserLoginDto;
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

    @GetMapping("/home")
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
            result.getFieldErrors().forEach(error -> redirectAttributes.addFlashAttribute("error_" + error.getField(), error.getDefaultMessage()));
            return new RedirectView("/signup", true);
        }
        try {
            service.signup(dto);
            redirectAttributes.addFlashAttribute("success", "user registered with success");
            System.out.println("Success flash message set" + redirectAttributes.getFlashAttributes());
            return new RedirectView("/signup", true);
        } catch (UserAlreadyExistsException e) {
            redirectAttributes.addFlashAttribute("error_email", "Email address is already registered");
            return new RedirectView("/signup", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "error registering user  ");
            System.out.println(e.getMessage());
            return new RedirectView("/signup", true);
        }

    }

    @GetMapping("/login")
    public ModelAndView login () {
        return new ModelAndView("auth/login");
    }

    @PostMapping("/login")
    public RedirectView login ( @Valid @ModelAttribute("userLoginDto") UserLoginDto dto, BindingResult result, RedirectAttributes redirectAttributes, HttpSession session ) {
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(error -> redirectAttributes.addFlashAttribute("error_" + error.getField(), error.getDefaultMessage()));
            return new RedirectView("/login", true);
        }
        try {
            var user = service.login(dto);
            session.setAttribute("user", user);
            session.setAttribute("authenticated", true);
            System.out.println(user);
            return new RedirectView("/home", true);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            System.out.println("error password");
            return new RedirectView("/login", true);
        } catch (Exception e) {
            System.out.println("here");
            redirectAttributes.addFlashAttribute("error", "An error occurred during login");
            return new RedirectView("/login", true);
        }
    }
}