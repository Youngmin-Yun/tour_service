package com.tourService.service;

import java.util.List;

import com.tourService.mapper.MyTourListFestiMapper;
import com.tourService.vo.FestivalVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTourListFestiService {
    @Autowired
    MyTourListFestiMapper mapper;
    public void insertMyFesti(Integer id, Integer seq){
        mapper.insertMyFesti(id, seq);
    }
    public List<FestivalVO> selectMyFesti(Integer seq){
        return mapper.selectMyFesti(seq);
    }
    public void deleteMyFesti(Integer id, Integer seq){
        mapper.deleteMyFesti(id, seq);
    }
}
