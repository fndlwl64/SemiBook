package com.semi.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semi.book.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void authTest() throws Exception {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId("STARE");
        memberDTO.setPassword("1234");

        //when
        String body = mapper.writeValueAsString(
                memberDTO
        );
        //them
        final ResultActions actions =  mvc.perform(post("/authenticate")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                );
        actions.andExpect(status().isCreated());
    }


}
