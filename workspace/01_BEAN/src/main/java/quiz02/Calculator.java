package quiz02;

public class Calculator {

	// field(property)
	
	// constructor	(field가 없으면 constructor도 의미가 없기때문에 안 만든다)
	 
	// method (field가 안만들어져 있으면 디폴트로 생성해준다)
	public int add(int a, int b) {
		return a + b;
	}
	public int subtract(int a, int b) {
		return a - b;
	}
	public int multiply(int a, int b) {
		return a * b;
	}
	public double divide(int a, int b) {
		return (double)a / b;
	}
}
