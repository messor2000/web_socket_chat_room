package com.example.websocketschat.controller;

import com.example.websocketschat.model.ChatMessage;
import java.util.Objects;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

  @MessageMapping("/chat.register")
  @SendTo("/topic/public")
  public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
    Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", chatMessage.getSender());
    return chatMessage;
  }

  @MessageMapping("/chat.send")
  @SendTo("/topic/public")
  public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    return chatMessage;
  }

  @MessageMapping("/chat.edit.name")
  @SendTo("/topic/public")
  public ChatMessage editUsername(@Payload ChatMessage chatMessage) {
    return chatMessage;
  }
}
