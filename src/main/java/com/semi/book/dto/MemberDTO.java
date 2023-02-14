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
    private Gender gender;
    private String userId;
    private String password;
    private String phone;
    private String address;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Grade grade;
    private State state;

}
