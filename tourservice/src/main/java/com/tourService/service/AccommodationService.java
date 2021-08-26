package com.tourService.service;

import java.util.List;

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
    public List<AccommodationVO> selectAccommodation(String type, String region){
        return mapper.selectAccommodation(type, region);
    }
}
