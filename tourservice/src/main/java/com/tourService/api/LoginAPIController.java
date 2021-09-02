package com.tourService.api;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.tourService.service.LoginService;
import com.tourService.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAPIController {
    @Autowired
    LoginService service;
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginVO vo, HttpSession session){
        Map<String, Object> resultMap = service.login(vo);
        session.setAttribute("member", resultMap.get("member"));
        return resultMap;
    }
}
