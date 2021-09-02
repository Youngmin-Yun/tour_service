package com.tourService.service;

import java.util.List;

import com.tourService.mapper.MyTourListAccMapper;
import com.tourService.vo.AccommodationVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTourListAccService {
    @Autowired
    MyTourListAccMapper mapper;
    public void insertMyAccList(Integer id, Integer seq){
        mapper.insertMyAccList(id, seq);
    }
    public List<AccommodationVO> selectMyAccList(Integer seq){
        return mapper.selectMyAccList(seq);
    }
    public void deleteMyAcc(Integer id, Integer seq){
        mapper.deleteMyAcc(id, seq);
    }
}
