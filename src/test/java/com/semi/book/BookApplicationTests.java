package com.semi.book;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.dto.MemberLoginRequestDTO;
import com.semi.book.repository.MemberRepository;
import com.semi.book.service.MemberService;
import com.semi.book.service.SecurityUtil;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
class BookApplicationTests {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;

	private String token = null;

	@Order(1)
	@Test
	public void postMemberTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName("JOJO");
		memberDTO.setGrade("NORMAL");
		memberDTO.setState("ON");
		memberDTO.setUserId("STAR");
		memberDTO.setAddress("SEOUL");
		memberDTO.setPhone("010-0000-2222");
		memberDTO.setGender("MALE");
		memberDTO.setPassword("1234");
		memberDTO.setEmail("fndlwl@gmail.com");
		memberDTO.setRoles(new ArrayList<>(Arrays.asList("USER")));
		//when
		String body = mapper.writeValueAsString(
				memberDTO
		);

		//then
		mvc.perform(post("/api/post/member")
				.content(body)
				.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk())
				.andExpect(content().string("1"))
				;
	}
	@Order(2)
	@Test
	public void loginTest() throws Exception {
		MemberLoginRequestDTO dto = new MemberLoginRequestDTO();
		dto.setUserId("STAR");
		dto.setPassword("1234");
		String body = mapper.writeValueAsString(
				dto
		);
		//then
		mvc.perform(post("/api/post/login")
						.content(body)
						.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	@Order(3)
	@Test
	public void findIdTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName("JOJO");
		memberDTO.setEmail("fndlwl@gmail.com");
		//when
		String body = mapper.writeValueAsString(
				memberDTO
		);
		//then
		mvc.perform(post("/api/get/findId")
						.content(body)
						.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.userId").value("STAR"))
		;
	}
	@Test
	public void findPwdTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId("STAR");
		memberDTO.setEmail("fndlwl@gmail.com");
		//when
		String body = mapper.writeValueAsString(
				memberDTO
		);
		//then
		mvc.perform(post("/api/get/findPwd")
						.content(body)
						.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.password").value("1234"));
	}
//	@Test
//	public void findPwdFailTest() throws Exception{
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setUserId("ST");
//		memberDTO.setEmail("fndlwl@gmail.com");
//		//when
//		String body = mapper.writeValueAsString(
//				memberDTO
//		);
//		//then
//		mvc.perform(post("/api/get/findPwd")
//						.content(body)
//						.contentType(MediaType.APPLICATION_JSON)
//				)
//				.andExpect(status().isOk())
//				.andExpect(content().string("Wrong Id or Email"));
//	}
}
