package ua.com.values_injection.simple;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	@Value("The first message")
	private String message;

	@Value("The second message")
	private String additionalMsg;

	@Override
	public String getMessage() {
		return message + " and " + additionalMsg;
	}
}
