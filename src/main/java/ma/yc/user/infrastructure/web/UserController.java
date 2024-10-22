package ma.yc.user.infrastructure.web;

import lombok.RequiredArgsConstructor;
import ma.yc.user.application.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/hello")
    public ModelAndView home () {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", "Hello from the controller!");
        return modelAndView;
    }
}