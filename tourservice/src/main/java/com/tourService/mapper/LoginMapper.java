package com.tourService.mapper;

import com.tourService.vo.LoginVO;
import com.tourService.vo.MemberRegistVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    public Integer login(LoginVO vo);
    public MemberRegistVO selectMemberById(String id);
}
