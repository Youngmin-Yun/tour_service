package com.tourService.mapper;

import java.util.List;

import com.tourService.vo.AccommodationVO;
import com.tourService.vo.FestivalVO;
import com.tourService.vo.RegionalTourVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchMapper {
    public List<FestivalVO> selectFestival(String region);
    public List<RegionalTourVO> selectRegionalTour(String region);
    public List<AccommodationVO> selectAccommodation(String region);
}
