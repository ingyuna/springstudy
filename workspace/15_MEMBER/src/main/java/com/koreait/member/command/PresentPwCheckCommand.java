package com.koreait.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.koreait.member.dto.Member;
import com.koreait.member.util.SecurityUtils;

public class PresentPwCheckCommand {
	
	public Map<String, Boolean> execute(Model model) {		// DB가 필요없기 때문에 SqlSeesion은 없어도 되서 빼줌
		
		Map<String, Object> map = model.asMap();
		Member member = (Member)map.get("member");
		HttpSession session = (HttpSession)map.get("session");
		
		String pw1 = ((Member)session.getAttribute("loginUser")).getPw();	//  세션에 올라간 암호화된 비밀번호
		String pw2 = SecurityUtils.encodeBase64(member.getPw());			// 암호화가 되어 있지 않은 비밀번호
		
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("isCorrect", pw1.equals(pw2));
		return resultMap;
		

	}

}
