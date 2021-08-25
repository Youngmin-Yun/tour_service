package com.tourService.service;

import com.tourService.mapper.FestivalMapper;
import com.tourService.vo.FestivalVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FestivalService {
    @Autowired
    FestivalMapper mapper;
    public void insertFetivalInfo(FestivalVO vo){
        mapper.insertFetivalInfo(vo);
    }
}
