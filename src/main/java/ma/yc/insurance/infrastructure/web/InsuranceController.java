package ma.yc.insurance.infrastructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @GetMapping("/automobile")
    public ModelAndView automobile(){
        return new ModelAndView("insurance/automobile");
    }
}
