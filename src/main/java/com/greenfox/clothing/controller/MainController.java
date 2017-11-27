package com.greenfox.clothing.controller;

import com.greenfox.clothing.repository.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/"})
public class MainController {

    @Autowired
    ClothingRepository repo;

    @GetMapping("/warehouse")
    public String warehouse(Model model) {
        model.addAttribute("list", repo.findAll());
        System.out.println(repo.count());
        return "warehouse";
    }

}
