package ua.rafael.injection_types.setter.resource;

import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello world!";
	}
}
