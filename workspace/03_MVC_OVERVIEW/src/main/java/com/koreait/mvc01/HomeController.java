package com.koreait.mvc01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 	@Controller
 	안녕. 난 Controller야. 스프링에서는 일반 자바 클래스야.
 */
@Controller
public class HomeController {
	
	// 콘솔에 로그를 남기는 로거(logger)
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
		@RequestMapping
		안녕. 난 URLMapping을 인식하는 애너테이션이야.
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)	// value= 슬래쉬() ContextPath 구분
																// 구분이 되면, 아래 home() 메소드를 실행해라.
	public String home(Locale locale, Model model) {			// Model = request를 기반으로 만들어져있다. 
		
		// 로그 뿌리기
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );		// View에 전달하는 값
																// -> request에 담았다고 생각하면 된다. (request.setAttribute)
																// request에 setAttribute를 하면 포워드 했을때, view로 넘어갔었다.
		
		return "home";		// View의 이름(home.jsp)  (어디에도 forward 한다는 얘기는 없지만, forward 한다는게 여기 안에 들어있는거)
							// = 서버 타입을 home.jsp로 보내라. 
	}
	
}
