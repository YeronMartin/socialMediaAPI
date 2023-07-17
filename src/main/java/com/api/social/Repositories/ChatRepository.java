package com.api.social.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.api.social.Model.ChatModel;
import com.api.social.Model.UserModel;


@Repository
public interface ChatRepository extends CrudRepository<ChatModel, Long>{
    //public abstract ArrayList<ChatModel> findByUserId (Long userId);

    public abstract ChatModel findChatById(Long id);

    public abstract List<ChatModel> findAllByOrderByLastUpdateDateDesc();

    @Query (value = "SELECT c.* FROM CHATS c INNER JOIN USERS_CHATS uc ON c.id = uc.chats_id INNER JOIN USERS u ON u.id = uc.users_id  WHERE u.ID = ?1", nativeQuery = true)
    public List<ChatModel> getUserListByChatId (Long id);
}
