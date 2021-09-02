package com.tourService.service;

import com.tourService.mapper.MemberRegistMapper;
import com.tourService.vo.MemberRegistVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRegistService {
    @Autowired
    MemberRegistMapper mapper;
    public boolean registMember(MemberRegistVO vo){
        if(vo.getMb_id()== ""|| vo.getMb_id()==null){
            return false;
        }
        // 일단 비밀번호에 공백은 받지 안도록 했지만 차후에 비밀번호 길이도 지정해야함!!!
        if(vo.getMb_pwd()== ""|| vo.getMb_pwd()==null){
            return false;
        }
        if(vo.getMb_name()== ""|| vo.getMb_name()==null){
            return false;
        }
        if(vo.getMb_email()== ""|| vo.getMb_email()==null){
            return false;
        }
        if(vo.getMb_phone()== ""|| vo.getMb_phone()==null){
            return false;
        }
        if(vo.getMb_address()== ""|| vo.getMb_address()==null){
            return false;
        }
        mapper.registMember(vo);
        return true;
    }
    public boolean duplicateId(String id){
        return mapper.duplicateId(id)>0;
    }
}
