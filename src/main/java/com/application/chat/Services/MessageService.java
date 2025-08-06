package com.application.chat.Services;

import com.application.chat.Models.ChatForm;
import com.application.chat.Models.ChatMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private String message;
    private List<ChatMessage> messages;

    public void addMessage(ChatForm chatForm) {

        ChatMessage chatMessage = new ChatMessage();

        chatMessage.setUsername(chatForm.getUsername());

        switch (chatForm.getMessageType()) {
            case "Say":
                chatMessage.setText(chatForm.getMessageText());
                break;
            case "Shout":
                chatMessage.setText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setText(chatForm.getMessageText().toLowerCase());
                break;
        }

        this.messages.add(chatMessage);

    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    @PostConstruct
    public void postConstruct() {
        messages = new ArrayList<>();
    }

}
