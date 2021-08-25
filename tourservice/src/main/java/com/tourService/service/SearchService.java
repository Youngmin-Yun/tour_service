package com.tourService.service;

import java.util.List;

import com.tourService.mapper.SearchMapper;
import com.tourService.vo.AccommodationVO;
import com.tourService.vo.FestivalVO;
import com.tourService.vo.RegionalTourVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    @Autowired
    SearchMapper mapper;
    public List<FestivalVO> selectFestival(String region){
        return mapper.selectFestival(region);
    }
    public List<RegionalTourVO> selectRegionalTour(String region){
        return mapper.selectRegionalTour(region);
    }
    public List<AccommodationVO> selectAccommodation(String region){
        return mapper.selectAccommodation(region);
    }
}
