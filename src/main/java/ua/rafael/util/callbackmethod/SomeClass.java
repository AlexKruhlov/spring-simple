package ua.rafael.util.callbackmethod;

public class SomeClass {

	interface Callback {
		void callingBack();
	}

	Callback callback;

	public void register(Callback callback) {
		this.callback = callback;
	}

	public void doSomething() {
		System.out.println("Do something method...");
		callback.callingBack();
	}
}
