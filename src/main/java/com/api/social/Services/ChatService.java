package com.api.social.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.social.Model.ChatModel;
import com.api.social.Repositories.ChatRepository;
import com.api.social.Repositories.MessageRepository;
import com.api.social.Repositories.UserRepository;

@Service
public class ChatService {
    
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    public ArrayList<ChatModel> getChatList (){
        return (ArrayList<ChatModel>)chatRepository.findAll();
    }

    public ChatModel getChatById (Long id){
        return chatRepository.findChatById(id);
    }

    public List<ChatModel> getChatListOrderByLastUpdateDate (){
        return chatRepository.findAllByOrderByLastUpdateDateDesc();
    }

    public List<ChatModel> getUserListByChatId (Long id){
        return chatRepository.getUserListByChatId(id);
    }

    public ChatModel saveChat (ChatModel chatModel){
        return chatRepository.save(chatModel);
    }

    public ChatModel putChat(ChatModel chat){
        return chatRepository.save(chat);
    }

    public Boolean clearChatList (){
        try {
            chatRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteChatById (Long id){
        try {
            chatRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
