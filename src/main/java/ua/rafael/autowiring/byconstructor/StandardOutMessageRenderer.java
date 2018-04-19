package ua.rafael.autowiring.byconstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {

	@Autowired
	private MessageProvider messageProvider;

	public StandardOutMessageRenderer(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("You rnust set the property rnessageProvider of class:"
					+ StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}
}
