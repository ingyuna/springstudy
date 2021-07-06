package com.koreait.myproject.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.HomeDAO;
import com.koreait.myproject.dto.Member;

public class FindIdCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);
		Member findUser = homeDAO.findId(name, phone);
		
		if (findUser != null) {
			model.addAttribute("findUser", findUser);
		}

	}

}
