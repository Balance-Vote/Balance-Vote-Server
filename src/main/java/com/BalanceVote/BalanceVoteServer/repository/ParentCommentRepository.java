package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParentCommentRepository extends JpaRepository<ParentComment,Long> {

    List<ParentComment> findAllByPostId(String postId);
    List<ParentComment> findAllByUuid(String uuid);
}
