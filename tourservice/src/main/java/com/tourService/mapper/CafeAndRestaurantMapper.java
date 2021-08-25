package com.tourService.mapper;

import com.tourService.vo.CafeAndRestaurantVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeAndRestaurantMapper {
    public void insertCafeAndRestaurantInfo(CafeAndRestaurantVO vo);
}
