package com.koreait.myproject.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.HomeDAO;
import com.koreait.myproject.dto.Member;

public class FindPwCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setPw(pw);
		member.setEmail(email);

		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);
		homeDAO.changePw(member);
	}

}
