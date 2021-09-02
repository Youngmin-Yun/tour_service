package com.tourService.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tourService.service.MyTourListAccService;
import com.tourService.vo.AccommodationVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTourListAccAPIController {
    @Autowired
    MyTourListAccService service;
    @PostMapping("/api/insert/mytouracc")
    public Map<String, Object> addMyTourAcc(@RequestParam @Nullable Integer id, @RequestParam Integer[] seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        for(int i = 0; i < seq.length; i++){
            service.insertMyAccList(id, seq[i]);
        };
        resultMap.put("status", true);
        resultMap.put("message", "저장되었습니다");
        return resultMap;
    }
    @GetMapping("/api/select/mytouracc")
    public Map<String, Object> selectMyTourAcc(@RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<AccommodationVO> list = service.selectMyAccList(seq);
        resultMap.put("list", list);
        return resultMap;
    }
    @DeleteMapping("/api/delete/mytouracc")
    public Map<String, Object> deleteMyAccList (@RequestParam Integer id, @RequestParam Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteMyAcc(id, seq);
        resultMap.put("message", "삭제되었습니다.");
        return resultMap;
    }
}
