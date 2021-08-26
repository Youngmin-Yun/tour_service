package com.tourService.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccomSearchController {
    @GetMapping("/search/accom")
    public String getAccommodationSearch(){
        return "/clickIcon/accommodation/search";
    }
    
    @GetMapping("/search/accom/result")
    public String getResultSearch(@RequestParam @Nullable String type, @RequestParam String region){
        return "/clickIcon/accommodation/result";
    }
}
