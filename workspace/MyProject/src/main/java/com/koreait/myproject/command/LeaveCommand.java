package com.koreait.myproject.command;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.HomeDAO;
import com.koreait.myproject.dto.Member;

public class LeaveCommand implements HomeCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		
		long no = ((Member)session.getAttribute("loginUser")).getNo();
		
		HomeDAO homeDAO = sqlSession.getMapper(HomeDAO.class);
		
		int count = homeDAO.leave(no);
		
		if (count > 0) {
			session.invalidate();
		}		
		
	}

}
