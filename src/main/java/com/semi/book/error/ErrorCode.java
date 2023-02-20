package com.semi.book.error;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String name();
    HttpStatus getResultCode();
    String getResultMsg();
}
