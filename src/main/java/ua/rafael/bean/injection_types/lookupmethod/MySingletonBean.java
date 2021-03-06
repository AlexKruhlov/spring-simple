package ua.rafael.bean.injection_types.lookupmethod;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class MySingletonBean {

	public void showMessage() {
		System.out.println(getPrototypeBean().getTime());
	}

	@Lookup
	public abstract MyPrototypeBean getPrototypeBean();
}
