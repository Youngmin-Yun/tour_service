package com.tourService.mapper;

import com.tourService.vo.MemberRegistVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRegistMapper {
    public void registMember(MemberRegistVO vo);
    public Integer duplicateId(String id);
}
