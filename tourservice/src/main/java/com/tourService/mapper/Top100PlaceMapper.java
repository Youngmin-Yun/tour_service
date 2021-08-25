package com.tourService.mapper;

import com.tourService.vo.Top100PlaceVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Top100PlaceMapper {
    public void insertTop100PlaceInfo(Top100PlaceVO vo);
}
