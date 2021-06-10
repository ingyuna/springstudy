package ex10_component;

import org.springframework.stereotype.Component;

// Component("이름")를 주면 bean의 id가 된다.

@Component("bk")	// <bean id="bk" Class="Book" />  -> 아이디를 변경해줬다.
public class Book {
	public void info() {
		System.out.println("나는 책이다.");
	}
}
