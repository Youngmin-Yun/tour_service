package com.tourService.mapper;

import java.util.List;

import com.tourService.vo.FestivalVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyTourListFestiMapper {
    public void insertMyFesti(Integer id, Integer seq);
    public List<FestivalVO> selectMyFesti(Integer seq);
    public void deleteMyFesti(Integer id, Integer seq);
}
