package ua.rafael.bean.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageEventListener implements ApplicationListener<MessageEvent> {

	@Override
	public void onApplicationEvent(MessageEvent event) {
		MessageEvent messageEvent = (MessageEvent) event;
		System.out.println("Received: " + messageEvent.getMessage());
	}
}
