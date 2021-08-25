package com.tourService.mapper;

import com.tourService.vo.FestivalVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FestivalMapper {
    public void insertFetivalInfo(FestivalVO vo);
}
