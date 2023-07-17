package com.api.social.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.social.Model.MessageModel;
import com.api.social.Repositories.ChatRepository;
import com.api.social.Repositories.MessageRepository;
import com.api.social.Repositories.UserRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;

    public ArrayList<MessageModel> getMessageList (){
        return (ArrayList<MessageModel>)messageRepository.findAll();
    }

    public MessageModel getMessageById (Long id){
        return messageRepository.findMessageById(id);
    }
    
    public List<MessageModel> getMessageListChatId (Long id){
        return messageRepository.getMessageListByChat(id);
    }

    public List<MessageModel> getMessageListByUser (Long id){
        return messageRepository.getMessageListByUser(id);
    }

    public List<MessageModel> getMessageListOrdeByTimeDesc (){
        return messageRepository.findAllByOrderByTimeDesc();
    }

    public MessageModel saveMessage(Long userId, Long chatId, MessageModel message){
        message.setUser(userRepository.findUserById(userId));
        message.setChat(chatRepository.findChatById(chatId));
        return messageRepository.save(message);
    }

    public MessageModel putMessage (MessageModel messageModel){
        return messageRepository.save(messageModel);
    }

    public Boolean deleteMessageById (Long id){
        try {
            messageRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean clearChat (){
        try {
            messageRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
