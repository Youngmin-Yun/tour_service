package com.tourService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapSearchController {
    @GetMapping("/map")
    public String getMapSearch(){
        return "/clickIcon/map/search";
    }
}
