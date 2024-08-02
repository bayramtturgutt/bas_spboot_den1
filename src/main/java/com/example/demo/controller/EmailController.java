package com.example.demo.controller;

import com.example.demo.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @GetMapping("/emailForm")
    public String emailForm(Model model) {
        model.addAttribute("email", new Email());
        return "emailForm";
    }

    @PostMapping("/submitEmail")
    public String submitEmail(@ModelAttribute Email email, Model model) {
        model.addAttribute("email", email);
        return "result";
    }
}