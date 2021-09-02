package com.tourService.mapper;

import java.util.List;

import com.tourService.vo.AccommodationVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyTourListAccMapper {
    public void insertMyAccList(Integer id, Integer seq);
    public List<AccommodationVO> selectMyAccList(Integer seq);
    public void deleteMyAcc(Integer id, Integer seq);
}
