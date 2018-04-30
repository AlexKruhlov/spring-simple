package ua.rafael.bean.autowiring.byname;

import org.springframework.stereotype.Service;

@Service("simpleHello")
public class HelloWorldMessageProvider {

	public String getMessage() {
		return "Hello world!";
	}
}
