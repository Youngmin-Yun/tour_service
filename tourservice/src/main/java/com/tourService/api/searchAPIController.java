package com.tourService.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tourService.service.SearchService;
import com.tourService.vo.AccommodationVO;
import com.tourService.vo.FestivalVO;
import com.tourService.vo.RegionalTourVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class searchAPIController {
    @Autowired
    SearchService service;
    @GetMapping("/api/search/festival")
    public Map<String, Object> getFestivalInfo(@RequestParam String region){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        region = "%"+region + "%";
        List<FestivalVO> festival = service.selectFestival(region);
        resultMap.put("festival", festival);
        return resultMap;
    }
    @GetMapping("/api/search/tour")
    public Map<String, Object> getRegionalTourInfo(@RequestParam String region){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        region = "%"+region + "%";
        List<RegionalTourVO> tour = service.selectRegionalTour(region);
        resultMap.put("tour", tour);
        return resultMap;
    }
    @GetMapping("/api/search/accommodation")
    public Map<String, Object> getAccommodationInfo(@RequestParam String region){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        region = "%"+region + "%";
        List<AccommodationVO> accommodation = service.selectAccommodation(region);
        resultMap.put("accommodation", accommodation);
        return resultMap;
    }
}
