package com.tourService.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tourService.service.MyTourListFestiService;
import com.tourService.vo.FestivalVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTourListFestiAPIController {
    @Autowired
    MyTourListFestiService service;
    @PostMapping("/api/mytourlist/festi")
    public Map<String, Object> getMyFesti(@RequestParam @Nullable Integer id, @RequestParam Integer[] seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        for(int i = 0; i<seq.length; i++){
            service.insertMyFesti(id, seq[i]);
        }
        resultMap.put("status", true);
        resultMap.put("message", "저장되었습니다");
        return resultMap;
    }
    @GetMapping("/api/mytourlist/festi")
    public Map<String, Object> selectMyFesti(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<FestivalVO> list = service.selectMyFesti(seq);
        resultMap.put("list", list);
        resultMap.put("message", "호출되었습니다");
        return resultMap;
    }
    
    @DeleteMapping("/api/delete/mytourfesti")
    public Map<String, Object> deleteMyFestiList (@RequestParam Integer id, @RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteMyFesti(id, seq);
        resultMap.put("message", "삭제되었습니다.");
        return resultMap;
    }
}
