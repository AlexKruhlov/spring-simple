package ua.rafael.bean.autowiring.byname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardOutMessageRenderer{

	/**
	 * helloAnotherWorldMessageProvider is a default
	 * @see HelloAnotherWorldMessageProvider bean name.
	 */
	@Autowired
	private HelloWorldMessageProvider message;

	public HelloWorldMessageProvider getMessageProvider() {
		return this.message;
	}
}
