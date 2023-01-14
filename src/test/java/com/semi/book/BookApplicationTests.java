package com.semi.book;

import com.semi.book.domain.Grade;
import com.semi.book.domain.Member;
import com.semi.book.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookApplicationTests {
	@Autowired
	private MemberRepository memberRepository;
	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("JPA TEST")
	@Transactional
	public void putMemberTest(){
		Member member = new Member();
		member.setName("JOJO");
		member.setUser_id("STAR PLATINUM");
		member.setGrade(Grade.NORMAL);
		memberRepository.save(member);

		Member findMember = memberRepository.findById((long) 1).get();
		assertEquals(findMember.getId(), 1L);
		assertEquals(findMember.getName(), "JOJO");
		assertEquals(findMember.getUser_id(),"STAR PLATINUM");
		assertEquals(findMember.getGrade(), Grade.NORMAL);

	}

}
