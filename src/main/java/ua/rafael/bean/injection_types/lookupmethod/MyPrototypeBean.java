package ua.rafael.bean.injection_types.lookupmethod;

import java.time.LocalDateTime;

public class MyPrototypeBean {
	private String time = String.valueOf(LocalDateTime.now().getNano());

	public String getTime() {
		return this.time;
	}
}
