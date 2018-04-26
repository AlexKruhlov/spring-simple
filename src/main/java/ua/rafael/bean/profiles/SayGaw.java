package ua.rafael.bean.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("sayer")
@Configuration
@Profile("gaw")
public class SayGaw implements Sayer {

	@Override
	public void saySomething() {
		System.out.println("Say gaw");
	}
}
