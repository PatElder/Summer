package heritage.restful.controller;

import heritage.restful.model.User;
import heritage.restful.service.SecurityService;
import heritage.restful.service.UserRegistrationDto;
import heritage.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Controller
    @RequestMapping("/registration")
    public class UserRegistrationController {

        @Autowired
        private UserService userService;

        @ModelAttribute("user")
        public UserRegistrationDto userRegistrationDto() {
            return new UserRegistrationDto();
        }

        @GetMapping
        public String showRegistrationForm(Model model) {
            return "registration";
        }

        @PostMapping
        public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                          BindingResult result) {

            User existing = userService.findByEmail(userDto.getEmail());
            if (existing != null) {
                result.rejectValue("email", null, "There is already an account registered with that email");
            }

            if (result.hasErrors()) {
                return "registration";
            }

            userService.save(userDto);
            return "redirect:/registration?success";
        }

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String login(Model model, String error, String logout) {
            if (error != null)
                model.addAttribute("error", "Your username and password is invalid.");

            if (logout != null)
                model.addAttribute("message", "You have been logged out successfully.");

            return "login";
        }

        // @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
        // public String welcome(Model model) {
        //     return "welcome";
        // }
    }
}
// https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/