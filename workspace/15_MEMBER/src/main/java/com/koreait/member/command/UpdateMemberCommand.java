package com.koreait.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;
import com.koreait.member.dto.Member;
import com.koreait.member.util.SecurityUtils;

public class UpdateMemberCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		// 가지고갈 3개 빼주기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		long no = Long.parseLong(request.getParameter("no"));
		
		// 이제 이걸 보낼 member를 만들어줌
		Member member = new Member();
		member.setName(SecurityUtils.xxs(name));
		member.setEmail(email);
		member.setNo(no);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.updateMember(member);
		
		if (count > 0) {
			HttpSession session = request.getSession();		// session에서 받아오기.
			Member loginUser = (Member)session.getAttribute("loginUser");
			loginUser.setName(name);
			loginUser.setEmail(email);
			
		}

	}

}
