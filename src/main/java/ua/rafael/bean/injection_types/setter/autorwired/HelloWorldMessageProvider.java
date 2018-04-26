package ua.rafael.bean.injection_types.setter.autorwired;

import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello world!";
	}
}
