package com.api.social.Model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String nick;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(
    name = "users_chats", 
    joinColumns = @JoinColumn(name = "users_id"),
    inverseJoinColumns = @JoinColumn(name = "chats_id"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"users_id", "chats_id"})})
    @JsonIgnore
    List<ChatModel> chats;  
    
}
