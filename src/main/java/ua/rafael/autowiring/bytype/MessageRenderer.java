package ua.rafael.autowiring.bytype;

public interface MessageRenderer {
	
	void render();
	
	void setMessageProvider(MessageProvider messageProvider);
	
	MessageProvider getMessageProvider();
}
