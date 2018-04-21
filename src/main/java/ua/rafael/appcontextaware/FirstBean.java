package ua.rafael.appcontextaware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class FirstBean {

	@PostConstruct
	public void init() {
		System.out.println("First bean initialization...");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("First bean destroying...");
	}
}
