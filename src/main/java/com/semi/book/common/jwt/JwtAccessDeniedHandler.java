package com.semi.book.common.jwt;

import com.semi.book.common.Cmmnvar;
import com.semi.book.common.response.ResVO;
import com.semi.book.error.CommonErrorCode;
import com.semi.book.error.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(JwtAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        ErrorCode errorCode = CommonErrorCode.FORBIDDEN;
        ResVO res = ResVO.builder()
                .status(errorCode.getResultCode().value())
                .message(errorCode.getResultMsg())
                .build();

        try{
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            writer.write(Cmmnvar.GSON.toJson(res));
        }finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
        response.getWriter().write(Cmmnvar.GSON.toJson(res));

    }
}
