package ua.rafael.beanname;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanName implements BeanNameAware {
	private String beanName;

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void doSomething() {
		System.out.println("BeanName is realy " + beanName);
	}
}
