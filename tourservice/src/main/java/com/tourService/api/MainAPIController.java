package com.tourService.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainAPIController {
    @GetMapping("/api/main")
    public void searchMain(@RequestParam String region){
        region = region + "%";
    }
}