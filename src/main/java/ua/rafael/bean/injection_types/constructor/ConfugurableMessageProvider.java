package ua.rafael.bean.injection_types.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class ConfugurableMessageProvider implements MessageProvider {
	private Object message;

	public ConfugurableMessageProvider(@Value("Configurable message") String message) {
		this.message = message;
	}

	@Autowired
	public ConfugurableMessageProvider(@Value("31415926") int message) {
		this.message = message;
	}

	@Override
	public Object getMessage() {
		return message;
	}
}
