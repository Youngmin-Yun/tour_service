package com.tourService.mapper;

import com.tourService.vo.AccommodationVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccommodationMapper {
    public void insertAccommodationInfo(AccommodationVO vo);
}
