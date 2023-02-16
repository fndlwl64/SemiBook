package com.semi.book.dto;

import com.semi.book.domain.Gender;
import com.semi.book.domain.Grade;
import com.semi.book.domain.State;
import lombok.*;

import java.time.LocalDateTime;

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
