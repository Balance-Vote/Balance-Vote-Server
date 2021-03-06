package com.BalanceVote.BalanceVoteServer.repository;

import java.util.List;
import java.util.Optional;

import com.BalanceVote.BalanceVoteServer.entity.VotePost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * VotePost Repositiory extending JpaRepository
 * @author DongGeon Lee
 */
public interface VotePostRepository extends JpaRepository<VotePost, Long>{

    Optional<VotePost> findByPostId(String postId);
    
    @Query(value="SELECT v.*, vote_cnt_1 + vote_cnt_2 AS tot_cnt FROM vote_post v ORDER BY tot_cnt DESC LIMIT :limit", nativeQuery=true)
    List<VotePost> findAllByVoteCount(@Param("limit") int limit);
}
