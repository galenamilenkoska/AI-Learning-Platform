package uikt.project.webapplication.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uikt.project.webapplication.model.entities.base.User;
import uikt.project.webapplication.model.enumerations.AcademicStatus;
import uikt.project.webapplication.model.exceptions.InvalidCredentialsException;
import uikt.project.webapplication.service.impl.UserService;

import java.time.LocalDate;

@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpServletRequest request,
                        Model model) {
        try {
            User user = userService.login(email, password);
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        } catch (InvalidCredentialsException e) {
            model.addAttribute("error", e.getMessage());
            return String.format("redirect:/login?error=%s", e.getMessage());
        }
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("academicStatuses", AcademicStatus.values());
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String firstName,
                           @RequestParam (required = false) String middleName,
                           @RequestParam String lastName,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                           @RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam AcademicStatus academicStatus,
                           Model model)
    {

        try {
            userService.register(username, email, password, repeatedPassword, firstName, middleName, lastName, dateOfBirth, academicStatus);
            return "redirect:/login";
        } catch (InvalidCredentialsException e) {
            model.addAttribute("error", e.getMessage());
            return String.format("redirect:/register?error=%s", e.getMessage());
        }

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
