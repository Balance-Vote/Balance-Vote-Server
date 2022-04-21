package com.BalanceVote.BalanceVoteServer.dto;

import com.BalanceVote.BalanceVoteServer.entity.VotePosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VotePositionCreation DTO
 * @author DongGeon Lee
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotePositionForm {
    private String selectedPos;
    private String uuid;

    public VotePosition toEntity(){
        return new VotePosition(null, selectedPos, null, uuid);
    }
}
