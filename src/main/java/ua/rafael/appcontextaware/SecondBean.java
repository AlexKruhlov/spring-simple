package ua.rafael.appcontextaware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class SecondBean {

	@PostConstruct
	public void init() {
		System.out.println("Second bean initialization...");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Second bean destroying...");
	}
}
