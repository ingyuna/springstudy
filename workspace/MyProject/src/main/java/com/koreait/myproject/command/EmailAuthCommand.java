package com.koreait.myproject.command;

import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;

import com.koreait.myproject.util.SecurityUtils;

public class EmailAuthCommand {

	@Autowired
	private JavaMailSender mailSender;
	
	public Map<String, String> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String email = request.getParameter("email");
		String authCode = null;
		
		// 이메일 작성
		MimeMessage message = mailSender.createMimeMessage();
		try {
			message.setHeader("Content-Type", "text/plain; charset=utf-8");
			message.setFrom(new InternetAddress("pinkspringyn@gmail.com", "관리자"));		
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));	  
			message.setSubject("인증 요청 메일입니다."); 
			authCode = SecurityUtils.getAuthCode(6);	// 6자리 인증코드
			message.setText("인증번호는 " + authCode + "입니다.");		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 이메일 보내기
		mailSender.send(message);
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("authCode", authCode);
		return resultMap;
		
		
		
		

	}

}
