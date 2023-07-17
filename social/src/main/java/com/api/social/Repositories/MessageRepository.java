package com.api.social.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.social.Model.MessageModel;

import jakarta.transaction.Transactional;

@Repository
public interface MessageRepository extends CrudRepository<MessageModel, Long>{

        public abstract MessageModel findMessageById(Long id);
        public abstract List<MessageModel> findAllByOrderByTimeDesc();

        @Query (value = "SELECT m.* FROM MESSAGES m INNER JOIN USERS u ON m.USER = u.ID WHERE u.ID = ?1", nativeQuery = true)
        public List<MessageModel> getMessageListByUser(Long id);

        @Query (value = "SELECT m.* FROM MESSAGES m WHERE m.chat_id = ?1", nativeQuery = true)
        public List<MessageModel> getMessageListByChat(Long id);

}
