package com.api.social.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.social.Model.UserModel;
import com.api.social.Repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public ArrayList<UserModel> getUserList (){
        return (ArrayList<UserModel>)userRepository.findAll();
    }

    public UserModel getUserById (Long id){
        return userRepository.findUserById(id);
    }

    public UserModel getUserByName (String userName){
        return userRepository.findByUserName(userName);
    }

    public UserModel getUserByNick(String nick){
        return userRepository.findByNick(nick);
    }

    public List<UserModel> getChatsByUserId (Long id){
        return userRepository.getChatListByUser(id);
    }


    public List<UserModel> getChatListByUser(Long id){
        return userRepository.getChatListByUser(id);
    }

    public UserModel saveUser (UserModel userModel){
        return userRepository.save(userModel);
    }

    public UserModel updateUserName (Long id, String newUserName){
        UserModel user = userRepository.findUserById(id);
        user.setUserName(newUserName);
        return userRepository.save(user);

    }

    public UserModel updateNick (Long id, String newNick){
        UserModel user = userRepository.findUserById(id);
        user.setNick(newNick);
        return userRepository.save(user);

    }
    
    public UserModel updateEmail (Long id, String newEmail){
        UserModel user = userRepository.findUserById(id);
        user.setEmail(newEmail);
        return userRepository.save(user);

    }

    public void clearUserList (){
        userRepository.deleteAll();
    }

    public boolean deleteUserById(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* USER-CHAT */
     public void saveUserChat (Long userId, Long chatId){
        userRepository.insertUserChat(userId, chatId);
    }

    public void deleteUserChat (Long userId, Long chatId){
        userRepository.deleteUserChat(userId, chatId);
    }
}
