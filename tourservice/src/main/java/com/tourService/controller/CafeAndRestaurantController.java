package com.tourService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CafeAndRestaurantController {
    @GetMapping("/topCafeAndRestaurant")
    public String getCafeAndRestaurant(){
        return "/clickIcon/cafeAndRestaurant";
    }
}
