package ua.rafael.values_injection.collections;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleCollection")
public class InjectSimpleCollection {

	@Value("#{injectConfig.names}")
	private List<String> names;

	@Value("#{injectConfig.nameMap}")
	private Map<Integer, String> nameMap;

	@Override
	public String toString() {
		return "InjectSimpleCollection [names=" + names + ", nameMap=" + nameMap + "]";
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		InjectSimpleCollection injectSimpleCollecion = context.getBean("injectSimpleCollection",
				InjectSimpleCollection.class);
		System.out.println(injectSimpleCollecion);
	}
}
