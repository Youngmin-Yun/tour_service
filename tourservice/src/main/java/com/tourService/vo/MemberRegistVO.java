package com.tourService.vo;

import lombok.Data;

@Data
public class MemberRegistVO {
    private Integer seq;
    private String mb_name;
    private String mb_pwd;
    private String mb_email;
    private String mb_id;
    private String mb_phone;
    private String mb_address;
}
