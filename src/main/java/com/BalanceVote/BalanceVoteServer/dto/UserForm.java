package com.BalanceVote.BalanceVoteServer.dto;

import com.BalanceVote.BalanceVoteServer.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User DTO
 * @author JunmanChoi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String nickname;
    private String uuid;

    /**
     * Converts data into User object
     */
    public User toEntity(){
        return new User(null,nickname,uuid);
    }
}
