package com.semi.book.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{

    FORBIDDEN(HttpStatus.FORBIDDEN, "웹 페이지를 볼 수 있는 권한이 없습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "리소스를 접근할 자격이 없습니다."),
    ;
    private final HttpStatus resultCode;
    private final String resultMsg;
}
