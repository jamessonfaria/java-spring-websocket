package br.com.jamesson.controller;

import br.com.jamesson.model.Message;
import br.com.jamesson.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MessageHandler {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String time = LocalTime.now().format(formatter);
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}
