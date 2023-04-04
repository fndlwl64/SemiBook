package com.semi.book.dto;

import lombok.Data;

@Data
public class MemberLoginRequestDTO {
    private String userId;
    private String password;
}
