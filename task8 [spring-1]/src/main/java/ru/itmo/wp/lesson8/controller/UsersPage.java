package ru.itmo.wp.lesson8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.lesson8.form.DisabledCredentials;
import ru.itmo.wp.lesson8.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UsersPage extends Page {
    private final UserService userService;

    public UsersPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "UsersPage";
    }

    @PostMapping("users/all")
    public String changeDisabled(@Valid @ModelAttribute("disableCredentials") DisabledCredentials disabledCredentials,
                                 Model model){
        model.addAttribute("users", userService.findAll());
        userService.changeDisabled(disabledCredentials.getId(), disabledCredentials.isDisabled());
        return "redirect:/users/all";
    }

}
