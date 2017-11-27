package com.greenfox.clothing.controller;

import com.greenfox.clothing.model.Response;
import com.greenfox.clothing.model.Warehouse;
import com.greenfox.clothing.repo.ClothingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class MController {

    @Autowired
    ClothingRepo repo;

    @GetMapping("/warehouse")
    public String warehouse(Model model) {
        model.addAttribute("list", repo.findAll());
        return "warehouse";
    }

    @PostMapping("warehouse/additem")
    public String add(@ModelAttribute Warehouse itemToBuy,
                      @RequestParam int quantity,
                      Model model) {
        List<Warehouse> basket = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            basket.add(itemToBuy);
        }
        model.addAttribute("basket", basket);
        return "summary";
    }

    @GetMapping("/warehouse/query")
    @ResponseBody
    public Response api(@RequestParam double price, @RequestParam String type) {
        List<Warehouse> list = new ArrayList<>();
        if (type.equals("lower")) {
            list=repo.findAllByUnitPriceIsLessThan(price);
        } else if (type.equals("higher")) {
            list=repo.findAllByUnitPriceIsGreaterThan(price);
        } else if (type.equals("equals")) {
            list=repo.findAllByUnitPriceEquals(price);
        }
        return new Response("ok", list);
    }
}
