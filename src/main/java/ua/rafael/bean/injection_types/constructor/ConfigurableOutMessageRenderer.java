package ua.rafael.bean.injection_types.constructor;

import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class ConfigurableOutMessageRenderer implements MessageRenderer {
	private MessageProvider messageProvider;

	public ConfigurableOutMessageRenderer(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("You rnust set the property rnessageProvider of class:"
					+ ConfigurableOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
}
