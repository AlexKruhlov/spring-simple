package ua.rafael.util.callbackmethod;

public class App {

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		SomeClass someClass = new SomeClass();
		someClass.register(myClass);
		someClass.doSomething();
	}
}
