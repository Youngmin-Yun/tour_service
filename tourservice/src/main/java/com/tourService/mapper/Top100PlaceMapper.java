package com.tourService.mapper;

import java.util.List;

import com.tourService.vo.Top100PlaceVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Top100PlaceMapper {
    public void insertTop100PlaceInfo(Top100PlaceVO vo);
    public List<Top100PlaceVO>selectTop100PlaceInfo();
}
