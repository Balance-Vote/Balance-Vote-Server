package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.ChildComment;
import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChildCommentRepository extends JpaRepository<ChildComment, Long> {
    List<ChildComment> findAllByUuid(String uuid);

    @Query(value = "SELECT child.* FROM balance_vote_database.child_comment child WHERE child.parent_id = :parentCmtId ORDER BY time_stamp DESC", nativeQuery = true)
    List<ChildComment> findAllByParentCmtId(@Param(value = "parentCmtId") Long parentCmtId);
}