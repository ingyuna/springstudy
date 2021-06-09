package ex03_xml;

import java.util.Map;

public class MapBean {

	// field(property)
	private Map<String, String> map;
	
	// constructor
	
	// method
	public void info() {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		/*
		 	Set<String> keys = map.keySet();
		 	for (String key : keys) {
		 		System.out.println(key + " : " map.get(key));
		 	}         											-> 위 아래는 같은 코드.
		*/
		
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
}
