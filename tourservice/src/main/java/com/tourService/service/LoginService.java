package com.tourService.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.tourService.mapper.LoginMapper;
import com.tourService.vo.LoginVO;
import com.tourService.vo.MemberRegistVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper mapper;
    public Map<String, Object> login(LoginVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Integer result = mapper.login(vo);
        System.out.println(result);
        if(result == 1){
            resultMap.put("status", true);
            MemberRegistVO member = mapper.selectMemberById(vo.getId());
            resultMap.put("member", member);
        }
        else{
            resultMap.put("status", false);
            resultMap.put("message", "존재하지 않는 회원입니다.");
        }
        return resultMap;
    }
}
