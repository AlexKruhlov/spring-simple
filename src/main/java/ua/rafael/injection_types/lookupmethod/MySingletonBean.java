package ua.rafael.injection_types.lookupmethod;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class MySingletonBean {

	public void showMessage() {
		System.out.println(getPrototypeBean().getTime());
	}

	@Lookup
	public MyPrototypeBean getPrototypeBean() {
		return null;
	}
}
