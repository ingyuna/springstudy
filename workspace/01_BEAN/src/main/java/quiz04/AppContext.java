package quiz04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	/*
	@Bean(name="lecture2")
	public Lecture xxxx() {
		return new Lecture("스프링을배우자", "제이미");
	}
	*/
	
	@Bean
	public Lecture lecture2() {
		return new Lecture("스프링을배우자", "제이미");
	}
	
	
	@Bean
	public Student student2() {
		return new Student("딸기", lecture2());
	}
	
	
	/*
	@Bean(name="student2")
	public Student yyyy() {
		return new Student("딸기", xxxx());
	}
	*/
	
	
	
	
}
