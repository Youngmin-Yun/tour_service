package com.tourService.service;

import java.util.List;

import com.tourService.mapper.CafeAndRestaurantMapper;
import com.tourService.vo.CafeAndRestaurantVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeAndRestaurantService {
    @Autowired
    CafeAndRestaurantMapper mapper;
    public void insertCafeAndRestaurantInfo(CafeAndRestaurantVO vo){
        mapper.insertCafeAndRestaurantInfo(vo);
    }
    public List<CafeAndRestaurantVO> selectCafeAndRestaurantInfo(){
        return mapper.selectCafeAndRestaurantInfo();
    }
}
