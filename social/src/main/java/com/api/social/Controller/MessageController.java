package com.api.social.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.social.Model.MessageModel;
import com.api.social.Services.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //GET METHODS
    @GetMapping()
    public List<MessageModel> getMessageList (){
        return messageService.getMessageList();
    }

    @GetMapping(path = "/{id}")
    public MessageModel getMessageById (@PathVariable("id") Long id){
        return messageService.getMessageById(id);
    }

    @GetMapping(path = "/{id}/chat")
    public List<MessageModel> getMessageListChatId (@PathVariable("id") Long id){
        return messageService.getMessageListChatId(id);
    }

    @GetMapping("/{id}/user")
    public List<MessageModel> getMessageListByUser (@PathVariable("id") Long id){
        return messageService.getMessageListByUser(id);
    }

    //POST METHODS
    @PostMapping("/{userId}/{chatId}")
    public MessageModel saveMessage(@PathVariable("userId") Long userId, 
    @PathVariable("chatId") Long chatId, @RequestBody MessageModel message){
        return messageService.saveMessage(userId, chatId, message);
    }

    //PUT METHODS
    @PutMapping()
    public MessageModel putMeessage(@RequestBody MessageModel message){
        return messageService.putMessage(message);
    }

    //DELETE METHODS
    @DeleteMapping()
    public Boolean clearChat (){
        return messageService.clearChat();
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteMessageById (@PathVariable("id") Long id){
        return messageService.deleteMessageById(id);
    }

    
    
}
