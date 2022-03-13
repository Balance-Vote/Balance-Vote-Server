package com.BalanceVote.BalanceVoteServer.dto;

import com.BalanceVote.BalanceVoteServer.entity.User;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
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
    @ApiModelProperty(example = "1", value = "유저 닉네임",required = true)
    private String nickname;
    @ApiModelProperty(example = "junman95", value = "범용 고유 식별자",required = true)
    private String uuid;

    /**
     * Converts data into User object
     */
    public User toEntity(){
        return new User(null,nickname,uuid);
    }
}
