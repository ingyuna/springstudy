package quiz05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("quiz05.xml")
public class AppContext {

	@Bean
	public Person husband1() {
		return new Person("제임스", "남");
	}
	
	@Bean
	public Person wife1() {
		return new Person("에이미", "여");
	}
	
	@Bean
	public HoneyMoon honeyMoon1() {
		return new HoneyMoon("파리", husband1(), wife1());
	}

	
}
