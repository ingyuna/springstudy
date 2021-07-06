package com.koreait.myproject.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.koreait.myproject.command.EmailAuthCommand;
import com.koreait.myproject.command.FindIdCommand;
import com.koreait.myproject.command.FindPwCommand;
import com.koreait.myproject.command.JoinCommand;
import com.koreait.myproject.command.LeaveCommand;
import com.koreait.myproject.command.LoginCommand;
import com.koreait.myproject.command.LogoutCommand;

@Configuration
public class BeanConfiguration {

	@Bean
	  public DriverManagerDataSource dataSource() {
	  	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  	  dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	  	  dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
	  	  dataSource.setUsername("spring");
	  	  dataSource.setPassword("1111");
	  	  return dataSource;
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
  	SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
  	sqlSessionFactory.setDataSource(dataSource());
  	sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/koreait/myproject/dao/*.xml"));
  	return sqlSessionFactory.getObject();
	}
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
 		return new SqlSessionTemplate(sqlSessionFactory());
	}	
	
	@Bean
	public EmailAuthCommand emailAuthCommand() {
		return new EmailAuthCommand();
	}
	
	@Bean
	public JoinCommand joinCommand() {
		return new JoinCommand();
	}
	
	@Bean
	public LoginCommand loginCommand() {
		return new LoginCommand();
	}
	
	@Bean
	public LogoutCommand logoutCommand() {
		return new LogoutCommand();
	}
	
	@Bean
	public FindIdCommand findIdCommand() {
		return new FindIdCommand();
	}
	
	@Bean
	public FindPwCommand findPwCommand() {
		return new FindPwCommand();
	}
	
	@Bean
	public LeaveCommand leaveCommand() {
		return new LeaveCommand();
	}
	
}
