package org.example;

import org.example.Questions.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.w3c.dom.UserDataHandler;

import java.util.HashMap;


public class Bot extends TelegramLongPollingBot {

    private final AbstractQuestions[] questions;
    private HashMap<Long, UserData> users;

    public Bot() {
        questions = new AbstractQuestions[]{
                new JavaQuestion(),
                new HTTPQuestion(),
                new SQLQuestion(),
                new GitQuestion()
        };
    }

    @Override
    public String getBotUsername() {
        return "new_java_bot";
    }

    @Override
    public String getBotToken() {
        return "";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        long idUser = message.getFrom().getId();
        User user = message.getFrom();

        if (text.equals("/start")) {
            users.put(idUser, new UserData());
            sendText(idUser,"Privet "+user.getFirstName()+ " Yopta");
        }
    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}

