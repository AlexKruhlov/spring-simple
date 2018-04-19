package ua.rafael.autowiring.byname;

public interface MessageRenderer {
	
	void render();
	
	void setMessageProvider(MessageProvider messageProvider);
	
	MessageProvider getMessageProvider();
}
