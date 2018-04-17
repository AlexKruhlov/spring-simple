package ua.rafael.values_injection.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpel")
public class InjectSimpleSpel {

	@Value("#{injectConfig.name}")
	private String name;

	@Value("#{injectConfig.age}")
	private int age;

	@Value("#{injectConfig.heigh}")
	private float heigh;

	@Value("#{injectConfig.programer}")
	private boolean programer;

	@Value("#{injectConfig.ageInSeconds}")
	private long ageInSeconds;

	@Override
	public String toString() {
		return "InjectSimpleSpel [name=" + name + ", age=" + age + ", heigh=" + heigh + ", programer=" + programer
				+ ", ageInSeconds=" + ageInSeconds + "]";
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		InjectSimpleSpel injectSimpleSpel = context.getBean("injectSimpleSpel", InjectSimpleSpel.class);
		System.out.println(injectSimpleSpel);
	}
}
