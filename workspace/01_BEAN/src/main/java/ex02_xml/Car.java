package ex02_xml;

public class Car {

	// field(property)
	private String model;
	private Engine engine;
	
	// constructor
	public Car() {
		
	}

	public Car(String model, Engine engine) {
		super();
		this.model = model;
		this.engine = engine;
	}
	
	// method
	public void info() {
		System.out.println("자동차모델: " + model);
		System.out.println("엔진타입: " + engine);
	}

	
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
	
	
	
	
	
}