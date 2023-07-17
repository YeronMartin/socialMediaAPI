package com.api.social.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.social.Model.ChatModel;
import com.api.social.Services.ChatService;

@RestController
@RequestMapping("/chats")
public class ChatController {
    
    @Autowired
    ChatService chatService;

    //GET METHODS
    @GetMapping()
    public List<ChatModel> getChatList (){
        return chatService.getChatList();
    }

    @GetMapping("/{id}")
    public ChatModel getChatById (@PathVariable("id") Long id){
        return chatService.getChatById(id);
    }

    @GetMapping("/chatsUpdated")
    public List<ChatModel> getChatListByIdOrderByLastUpdateDate (@PathVariable("id") Long id){
        return chatService.getChatListOrderByLastUpdateDate();
    }

    @GetMapping("/{id}/users")
    public List<ChatModel> getUserListByChatId (@PathVariable("id") Long id){
        return chatService.getUserListByChatId(id);
    }

    //POST METHODS
    @PostMapping()
    public ChatModel saveChat (@RequestBody ChatModel chat){
        return chatService.saveChat(chat);
    }

    //PUT METHODS
    @PutMapping("/{id}")
    public ChatModel putChat(@PathVariable("id")Long id,  @RequestBody ChatModel chat){
        return chatService.putChat(chat);
    }

    //DELETE METHODS
    @DeleteMapping()
    public Boolean clearChatList(){
        return chatService.clearChatList();
    }

    @DeleteMapping("/{id}")
    public Boolean clearChatById(@PathVariable("id") Long id){
        return chatService.deleteChatById(id);
    }
}
