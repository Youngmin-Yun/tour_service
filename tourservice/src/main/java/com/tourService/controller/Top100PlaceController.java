package com.tourService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Top100PlaceController {
    @GetMapping("/top100place")
    public String getPlace(){
        return "/clickIcon/Top100Place";
    }
}
