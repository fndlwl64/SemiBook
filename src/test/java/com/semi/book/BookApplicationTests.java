package com.semi.book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.semi.book.domain.Gender;
import com.semi.book.domain.Grade;
import com.semi.book.domain.Member;
import com.semi.book.domain.State;
import com.semi.book.dto.MemberDTO;
import com.semi.book.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableJpaAuditing
@AutoConfigureMockMvc
class BookApplicationTests {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	MockMvc mvc;
	@Autowired
	ObjectMapper mapper;


	@Test
	public void saveTest() throws Exception {
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
	@Transactional
	public void getMember(){
		Member findMember = memberRepository.findById(1L).get();
		assertEquals(findMember.getId(),1L);
		System.out.println("findMember.toString() = " + findMember.toString());
	}

}
