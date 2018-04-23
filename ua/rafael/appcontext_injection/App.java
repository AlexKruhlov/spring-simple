package ua.rafael.appcontext_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.appcontext_injection.childbeans.ChildConfig;
import ua.rafael.appcontext_injection.parentbeans.FirstParentComponent;
import ua.rafael.appcontext_injection.parentbeans.ParentConfig;

public class App {

	public static void main(String[] args) {
		ApplicationContext parentContext = new AnnotationConfigApplicationContext(ParentConfig.class);
		ApplicationContext childContext = new AnnotationConfigApplicationContext(ChildConfig.class);
		((AnnotationConfigApplicationContext) childContext).setParent(parentContext);
		FirstParentComponent firstParentComponent = childContext.getBean("firstParentComponent",
				FirstParentComponent.class);
		System.out.println(firstParentComponent);
	}
}
