package ua.rafael.autowiring.defaultt;

public interface MessageRenderer {
	
	void render();
	
	void setMessageProvider(MessageProvider messageProvider);
	
	MessageProvider getMessageProvider();
}
