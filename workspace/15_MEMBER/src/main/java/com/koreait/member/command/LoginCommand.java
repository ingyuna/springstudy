package com.koreait.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;
import com.koreait.member.dto.Member;
import com.koreait.member.util.SecurityUtils;

public class LoginCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 암호화 된 pw
		String encodedPw = SecurityUtils.encodeBase64(pw);	// 암호화 된 pw
		
		// DTO 부르기
		Member member = new Member();
		member.setId(id);
		member.setPw(encodedPw);
		
		// DAO 부르기
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		Member loginUser = memberDAO.login(member);
		
		// 로그인에 입력된 정보는 세션에 올려두기
		if (loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
		}
		

	}

}
