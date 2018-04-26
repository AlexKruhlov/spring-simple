package ua.rafael.bean.values_injection.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("ua/rafael/first.properties")
public class InjectProperties {

	@Autowired
	Environment env;

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Environment env = context.getBean(Environment.class);
		System.out.println(env.getProperty("key2"));
	}
}
