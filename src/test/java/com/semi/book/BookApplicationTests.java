package com.semi.book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.dto.MemberLoginRequestDTO;
import com.semi.book.repository.MemberRepository;
import com.semi.book.service.SecurityUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class BookApplicationTests {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;

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
		//when
		String body = mapper.writeValueAsString(
				memberDTO
		);
		//them
		mvc.perform(post("/api/post/member")
				.content(body)
				.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk())
				.andExpect(content().string("1"));
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
		//them
		mvc.perform(post("/api/post/login")
						.content(body)
						.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
//	@Test
//	public void getMemberTest(){
//		String userId = SecurityUtil.getCurrentMemberId();
//		Member findMember = memberRepository.findByUserId(userId).get();
//		assertEquals(findMember.getId(),1L);
//		System.out.println("findMember.toString() = " + findMember.toString());
//	}





}
