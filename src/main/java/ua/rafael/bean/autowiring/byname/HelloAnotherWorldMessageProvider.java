package ua.rafael.bean.autowiring.byname;

import org.springframework.stereotype.Service;

@Service
public class HelloAnotherWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello world to someone else!";
	}

}
