package ex02_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		String resourceLocations = "app-context2.xml";	// classpath는 생략가능하다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);

		Car myCar = ctx.getBean("car", Car.class);
		myCar.info();
		
		ctx.close();
	}

}
