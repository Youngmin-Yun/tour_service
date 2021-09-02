package com.tourService.mapper;

import java.util.List;

import com.tourService.vo.RegionalTourVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyTourListPlaceMapper {
    public void insertMyPlace(Integer id, Integer seq);
    public List<RegionalTourVO> selectMyPlace(Integer seq);
    public void deleteMyPlace (Integer id, Integer seq);
}
