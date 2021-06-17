package ex03_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
	@Autowired	(:클래스를 기반으로 동작한다)
	
	1. 객체의 타입(<bean class="'>)이 일치하는 객체를 자동으로 주입한다.
	2. 필드, 생성자, setter를 대상으로 한다.
	3. 별도의 디펜던시가 필요하지 않다.
*/

public class SelectListCommand {
	
	// 1. 필드에 주입
	/*
	@Autowired
	private Dao dao;
	*/
	
	// 2. 생성자를 이용한 주입	
	/*
	private Dao dao;
	
	@Autowired
	public SelectListCommand(Dao dao) {
		super();
		this.dao = dao;
	}
	*/
	
	// 3. setter를 이용한 주입
	/*
	private Dao dao;
	
	@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	*/
	
	
	// field
	private Dao dao;
	
	// constructor
	public SelectListCommand() {}
	public SelectListCommand(Dao dao) {
		super();
		this.dao = dao;
	}
	
	// setter
	@Autowired
	@Qualifier("boardDao1")		// <qualifer value="boardDao1" />
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	// getter
	public Dao getDao() {
		return dao;
	}
	
	public void execute() {
		dao.selectList();
	}
	
	

	
	

	
	
	
	
}
