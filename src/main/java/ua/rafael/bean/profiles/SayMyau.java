package ua.rafael.bean.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("sayer")
@Configuration
@Profile("myau")
public class SayMyau implements Sayer {

	@Override
	public void saySomething() {
		System.out.println("Say myau");
	}
}
