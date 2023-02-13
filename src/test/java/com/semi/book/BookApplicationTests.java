package com.semi.book;

import com.semi.book.domain.Gender;
import com.semi.book.domain.Grade;
import com.semi.book.domain.Member;
import com.semi.book.domain.State;
import com.semi.book.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableJpaAuditing
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
		Member member = Member.builder()
				.name("JOJO")
					.grade(Grade.NORMAL)
						.state(State.ON)
							.phone("010-2222-3333")
								.address("서울 양천구 목동아파트 101동 101호")
									.gender(Gender.MALE)
										.userId("STAR PLATINUM")
												.password("12341234")
														.name("JOJO").build();
		memberRepository.save(member);

		Member findMember = memberRepository.findById((long) 1).get();
		assertEquals(findMember.getId(), 1L);
		assertEquals(findMember.getName(), "JOJO");
		assertEquals(findMember.getUserId(),"STAR PLATINUM");
		assertEquals(findMember.getGrade(), Grade.NORMAL);
		assertEquals(findMember.getCreateDate(), findMember.getLastUpdatedDate());
	}

}
