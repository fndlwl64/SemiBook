package com.semi.book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.dto.User;
import com.semi.book.repository.MemberRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

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
		mvc.perform(post("/post/member")
				.content(body)
				.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk())
				.andExpect(content().string("1"));
	}
	@Test
	public void getMemberTest(){
		Member findMember = memberRepository.findById(1L).get();
		assertEquals(findMember.getId(),1L);
		System.out.println("findMember.toString() = " + findMember.toString());
	}

	@Test
	public void postUser() throws Exception {
		User user = new User();
		user.setUserId("STAR");
		user.setPassword("1234");
		//when
		String body = mapper.writeValueAsString(
				user
		);

		mvc.perform(post("/post/login")
				.content(body)
				.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk())
				.andExpect(content().string("1"));
	}

}
