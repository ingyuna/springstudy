package com.koreait.mvc03.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.mvc03.dto.Person;

@Controller
public class MyController4 {

	/*
		Spring의 Model 인터페이스
		
		1. ModelAndView 대신 사용된다.
		2. Model은 응답View로 값을 전달할 때 사용한다.
		3. Model은 내부적으로 request의 attribute를 이용한다.
			- 기존 : request.setAttribute("속성명", 값)
			- Model : model.addAttribute("속성명", 값)
		4. new Model()은 불가능하다. 메소드의 매개변수에 선언하고 사용한다.		
	*/
	
	@RequestMapping("f3/v01")
	public String a(Model model) {		// 반환타입 : String
		
		// 응답View에 전달할 데이터
		model.addAttribute("name", "브레드");
		model.addAttribute("age", 50);
		
		return "folder03/view01";
		
	}
	
	@RequestMapping("f3/v02")
	public String b(Model model) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "초코");
		map.put("age", "30");		// String으로 담기로 했기때문에 나이도 String 처리한다.
		
		model.addAttribute("map", map);
		
		return "folder03/view02";
			
	}
	
	// root-context.xml에 존재하는 bean 생성
	// @Inject, @Resource, @Autowired 등의 애너테이션 이용
	
	// <bean id="p1" class="com.koreait.mvc03.dto.Person">
	
	// 1. @Inject
	// 	  1) pop.xml에 디펜던시 추가 (02_DI 참고)
	// 	  2) 필드, 생성자, setter를 이용해 주입
	//    3) 클래스를 기반으로 생성(같은 클래스 타입을 찾아서 생성)
	//    4) 예시) 필드를 이용해 주입하기
	//		 @Inject
	//       private Person p;
	
	// 2. @Resource
	//    1) pop.xml에 디펜던시 추가(02_DI 참고)
	// 	  2) 필드, setter를 이용해 주입
	//    3) bean의 id를 기반으로 생성
	//    4) 예시) setter를 이용해 주입하기
	// 		 private Person p1;
	//       @Resource
	//       public void setP1(Person p1) {
	//       	  this.p1 = p1;
	//       }
	
	// 3. @Autowired
	//    1) 별도 디펜던시가 없다.
	//    2) 필드, 생성자, setter를 이용해 주입
	//    3) 클래스를 기반으로 생성(같은 클래스 타입을 찾아서 생성)	
	
	// field
	
	@Autowired		// root-context.xml에 만들어져있는 bean을 요 @Autowired가 가져와서 field 값으로 만들어준다.
	@Qualifier("p1")
	private Person person1;
	
	@RequestMapping("f3/v03")
	public String c(Model model) {
		
		model.addAttribute("person1", person1);
		
		return "folder03/view03";
		
	}
	
	@Autowired
	@Qualifier("p2")	
	private Person person2;
	
	@RequestMapping("f3/v04")
	public String d(Model model) {
		
		model.addAttribute("person2", person2);
		
		return "folder03/view04";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
