package ua.rafael.bean.values_injection.simple;

public interface MessageRenderer {

	void render();

	void setMessageProvider(MessageProvider messageProvider);

	MessageProvider getMessageProvider();
}
