package ex07_java_into_xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean(name="publisher2")
	public Publisher zzzzz() {		// 위에 이름 지정했기 때문에 여기서의 이름은 관심 없음.
		return new Publisher("스프링출판사", "경기도 성남시");
	}
	
	@Bean(name="book2")
	public Book yyyyy() {
		return new Book("나는스프링박사", 30000, zzzzz());
	}
}
