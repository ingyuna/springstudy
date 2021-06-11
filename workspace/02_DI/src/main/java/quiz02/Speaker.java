package quiz02;

public class Speaker {

	// field 
	private int vol; 	// 0~100
	
	// constructor
	
	// method	
	public void volup() {
		vol++;
		if (vol > 100) vol = 100;	// 볼륨이 100넘어가면 100으로 되게 한다. (최대값)
		System.out.println("현재 볼륨: " + vol);
	}
	public void volDown() {
		vol--;
		if (vol < 0) vol = 0;		// 볼륨이 0 이하 없이 0 고정
		System.out.println("현재 볼륨: " + vol);
	}
	
	
}
