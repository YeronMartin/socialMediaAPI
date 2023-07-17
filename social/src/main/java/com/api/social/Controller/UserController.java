package com.api.social.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.api.social.Model.UserModel;
import com.api.social.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUserList(){
        return userService.getUserList();
    }

    //GET METHODS
    @GetMapping(path = {"/{id}"})
    public UserModel getUserById (@PathVariable("id") Long id){
       return userService.getUserById(id);
    }

    @GetMapping(path = "/nick/{nick}")
    public UserModel getUserByNick (@PathVariable("nick") String nick){
       return userService.getUserByNick(nick);
    }

    @GetMapping(path = "/userName/{userName}")
    public UserModel getUserByName (@PathVariable("userName") String userName){
       return userService.getUserByName(userName);
    }

    @GetMapping(path = "/{id}/chats")
    public List<UserModel> getChatsByUserId (@PathVariable("id") Long id){
       return userService.getChatsByUserId(id);
    }

    //POST METHODS
    @PostMapping()
    public UserModel saveUser (@RequestBody UserModel user){
        return userService.saveUser(user);
    }

    //PUT METHODS
    @PutMapping("/{id}/userName")
    public UserModel updateUserName (@PathVariable("id") Long id, @RequestBody String newUserName){
        return userService.updateUserName(id, newUserName);
    }

    @PutMapping("/{id}/nick")
    public UserModel updateNick (@PathVariable("id") Long id, @RequestBody String newNick){
        return userService.updateNick(id, newNick);
    }

    @PutMapping("/{id}/email")
    public UserModel updateEmail (@PathVariable("id") Long id, @RequestBody String newEmail){
        return userService.updateEmail(id, newEmail);
    }

    //DELETE METHODS
    @DeleteMapping()
    public void clearUserList (){
        userService.clearUserList();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById (@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    /* USER_CHAT */
     @PostMapping(path = "/saveUserChat/{userId}/{chatId}")
    public void saveUsersChats (@PathVariable("userId") Long userId, @PathVariable("chatId") Long chatId){
        userService.saveUserChat(userId, chatId);
    }

    @DeleteMapping(path = "/deleteUserChat/{userId}/{chatId}")
    public void deleteUsersChats (@PathVariable("userId") Long userId, @PathVariable("chatId") Long chatId){
        userService.deleteUserChat(userId, chatId);
    }


}
