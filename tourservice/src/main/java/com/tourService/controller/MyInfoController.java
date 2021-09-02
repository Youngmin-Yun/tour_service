package com.tourService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyInfoController {
    @GetMapping("/myinfo")
    public String getMain(){
        return "/myinfo/myInfo";
    }
    @GetMapping("/myinfo/festi")
    public String getMyFestiInfo(){
        return "/myinfo/myInfoFesti";
    }
    @GetMapping("/myinfo/place")
    public String getMyPlaceInfo(){
        return "/myinfo/myInfoPlace";
    }
    @GetMapping("/myinfo/acc")
    public String getMyAccInfo(){
        return "/myinfo/myInfoAcc";
    }
}
