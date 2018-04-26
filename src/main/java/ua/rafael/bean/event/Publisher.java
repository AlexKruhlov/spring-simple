package ua.rafael.bean.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Publisher implements ApplicationContextAware {
	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public void publish(String message) {
		context.publishEvent(new MessageEvent(this, message));
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Publisher publisher = context.getBean(Publisher.class);
		publisher.publish("Hello, It's me!!!!");
		publisher.publish("It's my second message!!!");
		publisher.publish("It's my third message!!!");
	}
}
