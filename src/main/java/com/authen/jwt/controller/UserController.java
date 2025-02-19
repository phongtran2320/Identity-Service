package com.authen.jwt.controller;

import com.authen.jwt.exception.ApplicationException;
import com.authen.jwt.entity.User;
import com.authen.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> userList = userService.showUserList();
        model.addAttribute("userList", userList);
        model.addAttribute("pageTitle", "Add New User");
        return "users_page";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        userService.saveUser(user);
        ra.addFlashAttribute("message", "The user has been saved");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = userService.findById(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User(ID: " + id + ")");
            return "user_form";
        } catch (ApplicationException exception) {
            ra.addFlashAttribute("message", exception.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            userService.deleteUser(id);
            ra.addFlashAttribute("message","The user ID " + id + " has been deleted.");
        } catch (ApplicationException exception) {
            ra.addFlashAttribute("message", exception.getMessage());
        }
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Integer id) throws ApplicationException{
        return userService.findById(id);
    }

}
