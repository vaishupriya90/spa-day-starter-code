package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("")
    public String displayAllUsers(Model model){
        List<User> users = UserData.getAll();
        model.addAttribute("users",users);
        model.addAttribute("title","Registered Users");
        return "user/index";

    }
    @GetMapping("detail/{id}")
    public String displayUserDetail(@PathVariable int id,Model model){
        User user = UserData.getById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","User Details");
        return "user/userDetail";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("title","User Registration Form");
        return "user/add";
    }

    @PostMapping("add")
    public String processingAddUserForm(@ModelAttribute User newUser, String verifyPassword, Model model){

        model.addAttribute("userName",newUser.getUserName());
        //model.addAttribute("email",newUser.getEmail());
        //model.addAttribute("verify",verifyPassword);

        if(verifyPassword.equals(newUser.getPassword())){
            UserData.add(newUser);
            return "redirect:/user";
        }
        model.addAttribute("error", "Passwords do not match");
        return "user/add";

    }
}
