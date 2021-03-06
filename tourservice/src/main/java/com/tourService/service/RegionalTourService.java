package com.tourService.service;

import java.util.List;

import com.tourService.mapper.RegionalTourMapper;
import com.tourService.vo.RegionalTourVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionalTourService {
    @Autowired
    RegionalTourMapper mapper;
    public void insertRegionalTourInfo(RegionalTourVO vo){
        mapper.insertRegionalTourInfo(vo);
    }
    public List<RegionalTourVO> selectRegionalTourInfo(String region){
        return mapper.selectRegionalTourInfo(region);
    }
}
