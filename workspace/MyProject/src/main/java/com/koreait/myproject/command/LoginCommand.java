package com.koreait.myproject.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.HomeDAO;
import com.koreait.myproject.dto.Member;

public class LoginCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);
		Member loginUser = homeDAO.login(member);
		
		// 로그인 정보 세션에 저장
		if (loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
		}
		

	}

}
