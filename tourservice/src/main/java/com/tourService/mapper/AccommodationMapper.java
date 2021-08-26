package com.tourService.mapper;

import java.util.List;

import com.tourService.vo.AccommodationVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccommodationMapper {
    public void insertAccommodationInfo(AccommodationVO vo);
    public List<AccommodationVO> selectAccommodation(String type, String region);
}
