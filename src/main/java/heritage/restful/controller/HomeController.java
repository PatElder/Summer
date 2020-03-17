package heritage.restful.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeController {

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = {"/pages"}, method = RequestMethod.POST)
    public String pages(Model model) {
        return "pages";
    }

//    @GetMapping("/")
//    public String root() {
//        return "index";
//    }
//
//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}

