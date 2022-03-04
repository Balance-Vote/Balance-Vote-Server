package com.BalanceVote.BalanceVoteServer.dto;

import com.BalanceVote.BalanceVoteServer.entity.VotePost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VotePostCreation DTO
 * @author DongGeon Lee
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotePostCreateForm {
    private String selectionOne;
    private String selectionTwo;
    private String uuid;

    public VotePost toEntity(){
        return new VotePost(null, selectionOne, selectionTwo, 0, 0, null, uuid);
    }
}
