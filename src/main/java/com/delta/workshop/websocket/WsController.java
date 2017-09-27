package com.delta.workshop.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WsResponse say(WsMessage message) throws InterruptedException {
		Thread.sleep(3000);
		return new WsResponse("welcome"+message.getMessage());
	}
}


