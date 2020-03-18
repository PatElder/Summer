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
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;


@Controller
public class HomeController implements SummerController {

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
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

    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)

            throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();

        WebContext ctx =
                new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("today", dateFormat.format(cal.getTime()));


        templateEngine.process("welcome", ctx, response.getWriter());
    }
}

