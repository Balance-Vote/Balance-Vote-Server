package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.ChildComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChildCommentRepository extends JpaRepository<ChildComment, Long> {
    List<ChildComment> findAllByUuid(String uuid);
}
