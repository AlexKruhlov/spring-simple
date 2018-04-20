package ua.rafael.util.callbackmethod;

public class MyClass implements SomeClass.Callback {

	@Override
	public void callingBack() {
		System.out.println("CallingBack method...");
	}
}
