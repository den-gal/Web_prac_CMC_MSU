package Web_prog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allFilms() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start_page");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public ModelAndView sign_in() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign_in");
        return modelAndView;
    }

    @RequestMapping(value = "/confirm_form", method = RequestMethod.GET)
    public ModelAndView confirm_form() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm_form");
        return modelAndView;
    }
}
