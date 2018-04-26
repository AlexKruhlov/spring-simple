package ua.rafael.bean.values_injection.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("injectConfig")
public class InjectConfig {
	private List<String> names = new ArrayList<>();
	private Map<Integer, String> nameMap = new HashMap<>();

	public InjectConfig() {
		this.names.add("First list name");
		this.names.add("Second list name");

		this.nameMap.put(1, "First map name");
		this.nameMap.put(2, "Second map name");
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Map<Integer, String> getNameMap() {
		return nameMap;
	}

	public void setNameMap(Map<Integer, String> nameMap) {
		this.nameMap = nameMap;
	}
}
