package com.tourService.mapper;

import com.tourService.vo.RegionalTourVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegionalTourMapper {
    public void insertRegionalTourInfo(RegionalTourVO vo);
}
