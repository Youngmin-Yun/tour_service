package com.tourService.service;

import java.util.List;

import com.tourService.mapper.MyTourListPlaceMapper;
import com.tourService.vo.RegionalTourVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTourListPlaceService {
    @Autowired
    MyTourListPlaceMapper mapper;
    public void insertMyPlace(Integer id, Integer seq){
        mapper.insertMyPlace(id, seq);
    }
    public List<RegionalTourVO> selectMyPlace(Integer seq){
        return mapper.selectMyPlace(seq);
    }
    public void deleteMyPlace (Integer id, Integer seq){
        mapper.deleteMyPlace(id, seq);
    }
}
