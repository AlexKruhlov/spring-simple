package ua.rafael.values_injection.simple;

public interface MessageRenderer {

	void render();

	void setMessageProvider(MessageProvider messageProvider);

	MessageProvider getMessageProvider();
}
