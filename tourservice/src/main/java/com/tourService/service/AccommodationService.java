package com.tourService.service;

import com.tourService.mapper.AccommodationMapper;
import com.tourService.vo.AccommodationVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationService {
    @Autowired
    AccommodationMapper mapper;
    public void insertAccommodationInfo(AccommodationVO vo){
        mapper.insertAccommodationInfo(vo);
    }
}
