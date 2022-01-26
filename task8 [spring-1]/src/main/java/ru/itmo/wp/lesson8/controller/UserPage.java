package ru.itmo.wp.lesson8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itmo.wp.lesson8.domain.User;
import ru.itmo.wp.lesson8.service.UserService;

@Controller
public class UserPage extends Page {
    private final UserService userService;


    public UserPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{id}")
    public String user(Model model, @PathVariable String id) {
        try {
            User user = userService.findById(Long.valueOf(id));
            model.addAttribute("user", user);
        } catch (NumberFormatException ignored) {
            model.addAttribute("user", null);
        }
        return "UserPage";
    }

//    @GetMapping("user/")
//    public String user(Model model) {
//        return "UserPage";
//    }
}
