package com.koreait.myproject.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.HomeDAO;
import com.koreait.myproject.dto.Member;

public class JoinCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
	
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setPhone(phone);
		member.setEmail(email);
		member.setAddress(address);
		
		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);
		homeDAO.join(member);
	}

}
