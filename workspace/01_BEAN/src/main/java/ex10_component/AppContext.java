package ex10_component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="ex10_component")
// @ComponentScan(basePackages={"ex10_component"}) -> 패키지가 여러개가 있을 경우 이렇게 배열로 등록할 수 있다.
public class AppContext {

}
