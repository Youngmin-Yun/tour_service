package com.tourService.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tourService.service.MyTourListPlaceService;
import com.tourService.vo.RegionalTourVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTourListPlaceAPIController {
    @Autowired
    MyTourListPlaceService service;
    @PostMapping("/api/mytourlist/list")
    public Map<String, Object> addMyPlace(@RequestParam @Nullable Integer id, @RequestParam Integer[] seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        for(int i=0; i<seq.length; i++) {
            service.insertMyPlace(id, seq[i]);
        }
        resultMap.put("status", true);
        resultMap.put("message", "저장되었습니다");
        return resultMap;
    }
    @GetMapping("/api/mytourlist/list")
    public Map<String, Object> selectMyPlace(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<RegionalTourVO> list = service.selectMyPlace(seq);
        resultMap.put("list", list);
        return resultMap;
    }
    @DeleteMapping("/api/delete/mytourPlace")
    public Map<String, Object> deleteMyPlace (@RequestParam Integer id, @RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteMyPlace(id, seq);
        resultMap.put("message", "삭제되었습니다.");
        return resultMap;
    }
}
