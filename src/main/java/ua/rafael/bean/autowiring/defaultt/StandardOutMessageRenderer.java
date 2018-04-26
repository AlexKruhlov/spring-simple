package ua.rafael.bean.autowiring.defaultt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {
	
	/**
	 * Default realization of autowiring:
	 * 1. If Spring finds the constructor with parameters, 
	 *    it will try to wire beans on constructor way.
	 * 2. Spring try to wire beans on byType way.
	 */
	@Autowired
	private MessageProvider messageProvider;

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("You rnust set the property rnessageProvider of class:"
					+ StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
}
