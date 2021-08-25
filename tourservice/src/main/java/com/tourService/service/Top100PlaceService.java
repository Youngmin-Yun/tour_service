package com.tourService.service;

import com.tourService.mapper.Top100PlaceMapper;
import com.tourService.vo.Top100PlaceVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Top100PlaceService {
    @Autowired
    Top100PlaceMapper mapper;
    public void insertTop100PlaceInfo(Top100PlaceVO vo){
        mapper.insertTop100PlaceInfo(vo);
    }
}
