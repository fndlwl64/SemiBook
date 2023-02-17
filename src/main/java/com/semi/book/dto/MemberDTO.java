package com.semi.book.dto;

import lombok.*;

@Data
@ToString
public class MemberDTO {
    private Long id;
    private String name;
    private String gender;
    private String userId;
    private String password;
    private String phone;
    private String address;
    private String email;
    private String createDate;
    private String lastUpdateDate;
    private String grade;
    private String state;

}
