package com.tourService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @GetMapping("/search/festival")
    public String getFestivalInfo(@RequestParam String region){
        return "/search/searchFestival";
    }
    @GetMapping("/search/place")
    public String getPlaceInfo(@RequestParam String region){
        return "/search/searchPlace";
    }
    @GetMapping("/search/accommodation")
    public String getAccommodationInfo(@RequestParam String region){
        return "/search/searchAccommodation";
    }
}
