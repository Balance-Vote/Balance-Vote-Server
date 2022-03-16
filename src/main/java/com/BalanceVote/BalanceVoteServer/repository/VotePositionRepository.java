package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.VotePosition;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * VotePosition Repositiory extending JpaRepository
 * @author DongGeon Lee
 */
public interface VotePositionRepository extends JpaRepository<VotePosition, Long>{
    
}
