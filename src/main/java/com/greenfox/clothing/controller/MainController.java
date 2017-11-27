package com.greenfox.clothing.controller;

import com.greenfox.clothing.model.Response;
import com.greenfox.clothing.model.Product;
import com.greenfox.clothing.repo.ClothingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class MainController {

    @Autowired
    ClothingRepo repo;

    @GetMapping("/warehouse")
    public String warehouse(Model model) {
        model.addAttribute("list", repo.findAll());
        model.addAttribute("itemToBuy", new Product());
        return "warehouse";
    }

    @PostMapping("warehouse/additem")
    public String add(@ModelAttribute Product itemToBuy,
                      @RequestParam int quantity,
                      Model model) {
        double total = itemToBuy.getUnitPrice() * quantity;
        model.addAttribute("item", itemToBuy);
        model.addAttribute("quantity", quantity);
        model.addAttribute("total", total);
        return "summary";
    }

    @GetMapping("/warehouse/query")
    @ResponseBody
    public Response api(@RequestParam double price, @RequestParam String type) {
        List<Product> list = new ArrayList<>();
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
