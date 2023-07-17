package com.api.social.Repositories;


import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.social.Model.ChatModel;
import com.api.social.Model.MessageModel;
import com.api.social.Model.UserModel;

import jakarta.transaction.Transactional;



@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
   
    public abstract UserModel findUserById(Long id);
    public abstract UserModel findByUserName(String userName);
    public abstract UserModel findByNick(String nick);


    @Query (value = "SELECT u.* FROM USERS_CHATS uc INNER JOIN USERS u ON uc.USERS_ID = u.ID INNER JOIN CHATS c ON uc.CHATS_ID = c.ID WHERE c.ID = ?1", nativeQuery = true)
    public List<UserModel> getChatListByUser (Long id);


    //USER_CHAT INTEMEEDIATE TABLE QUERIES
    @Modifying
    @Transactional
    @Query (value = "INSERT INTO USERS_CHATS(users_id,chats_id) VALUES (?1, ?2)", nativeQuery = true)
    public abstract void insertUserChat(Long userId, Long chatId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM USERS_CHATS WHERE users_id=?1 AND chats_id=?2", nativeQuery = true)
    public abstract void deleteUserChat(Long userId, Long chatId);



}
