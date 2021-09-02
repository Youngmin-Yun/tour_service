package com.tourService.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.tourService.service.MemberRegistService;
import com.tourService.vo.MemberRegistVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRegistAPIController {
    @Autowired
    MemberRegistService service;
    @PostMapping("/api/memeberRegist")
    public Map<String, Object> addMember(@RequestBody MemberRegistVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        boolean member = service.registMember(vo);
        if(member){
            resultMap.put("result", "success");
            resultMap.put("message", "가입되었습니다.");
        }
        else{
            resultMap.put("result", "failed");
            resultMap.put("message", "회원가입이 되지 않았습니다.");
        }
        return resultMap;
    }
    @GetMapping("/api/memberRegist/id")
    public Map<String, Object> checkId(@RequestParam String id){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(service.duplicateId(id)){
            resultMap.put("status", true);
            resultMap.put("message", "사용중인 아이디가 있습니다");
        }
        else{
            resultMap.put("status", false);
            resultMap.put("message", "사용가능한 아이디 입니다");
        }
        return resultMap;
    }
}
