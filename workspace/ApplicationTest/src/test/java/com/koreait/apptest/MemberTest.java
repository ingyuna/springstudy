package com.koreait.apptest;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.apptest.config.BeanConfiguration;
import com.koreait.apptest.dao.MemberDAO;
import com.koreait.apptest.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {BeanConfiguration.class})	// @ContextConfiguration(classpath:aaa.xml) -> bean을 xml로 만들 경우.
		// Bean을 여러개 만들 수 있으니가 classes가 된다.
public class MemberTest {

	// junit 테스트는 스프링을 모두 돌리지 않는다.
	// @Autowired 동작 안 한다.
	// Oracle JDBC도 tomcat에 넣어 두면 동작하지 않는다.
	// 현재 프로젝트에 포함되어 있어야 한다. (pop.xml 참고)
	
	// junit 테스트 시 스프링 모든 기능 활용을 위해서
	// spring-test 디펜던시를 추가한다. (스프링 프레임워크와 같은 버전)
	
	// spring-test 디펜던시 지원 애너테이션
	// @RunWith : 이 테스트는 스프링을 함께 돌려달라. 
	// @ContextConfiguration : Bean을 여기서 찾아라.
	
	
	// field
	@Autowired
	private SqlSession SqlSession;
	
	@Test
	public void joinTest() {
		
		Member member = new Member();
		member.setId("test");
		member.setPw("1111");
		member.setName("테스트");
		member.setEmail("test@web.com");
		
		MemberDAO memberDAO = SqlSession.getMapper(MemberDAO.class);	
		int count = memberDAO.join(member);
		
		assertEquals("가입 실패", 1, count);	// 1과 count가 같은지 점검
		
		// 1과 count가 같으면 검사 통과
		// 1과 count가 다르면 검사 실패 (가입 실패)
		
	}
	
	// 아이디 중복 점검 테스트
	// admin 아이디를 가진 아이디가 있으면 검사 통과
	// admin 아이디를 가진 아이디가 없으면 검사 실패
	@Test
	public void 아이디중복체크테스트() {
		MemberDAO memberDAO = SqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.idCheck("admin");
		assertEquals("중복 체크 실패", 1, count);
	}
	
	
	

}
