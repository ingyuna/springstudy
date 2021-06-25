package com.koreait.member.command;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public class LogoutCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");		// 바로 session을 뺀거는 위에 model에 session을 넣었다는 말.
		
		if (session.getAttribute("loginUser") != null) {
			session.invalidate();
		}
		
	}

}
