package valent.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import valent.com.springboot.model.User;
import valent.com.springboot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/add_user")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }
    @PostMapping("/add_user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user){
        userService.change(user);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "/update";
    }

}

