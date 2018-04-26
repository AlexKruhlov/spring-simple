package ua.rafael.bean.autowiring.byname;

import org.springframework.stereotype.Service;

@Service("simpleHello")
public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello world!";
	}
}
