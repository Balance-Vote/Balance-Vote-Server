package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import com.BalanceVote.BalanceVoteServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParentCommentRepository extends JpaRepository<ParentComment,Long> {

    List<ParentComment> findAllByPostId(String postId);
}
