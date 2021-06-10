package ex01_inject;

public class SpringMainClass {

	public static void main(String[] args) {
		
		SelectListCommand selectListCommand = new SelectListCommand();	// bean으로 안만들어져 있으니까 직접 이렇게 만들어준다.
		selectListCommand.execute();

	}

}
