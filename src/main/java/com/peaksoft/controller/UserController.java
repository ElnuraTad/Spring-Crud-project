package com.peaksoft.controller;

import com.peaksoft.model.User;
import com.peaksoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //localhost:8080/users
    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    //localhost:8080/users/add-user
    @GetMapping("/add-user")
    public String addUser(User user){
        return "add-user";
    }

    //localhost:8080/users/save-user
    @PostMapping("/save-user")
    public String saveUser(User user, Model model){
        userService.addUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/users";
    }

    @GetMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.get(id));
        return "update-user";
    }

    //localhost:8080/users/edit-user
    @PatchMapping("/edit-user/{id}")
    public String editUser(@PathVariable("id") Integer id, @ModelAttribute("user") User user){
        userService.updateUser(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
