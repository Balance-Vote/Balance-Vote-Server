package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.ChildComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildCommentRepository extends JpaRepository<ChildComment, Long> {
}
