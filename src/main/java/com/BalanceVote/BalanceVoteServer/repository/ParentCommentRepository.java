package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParentCommentRepository extends JpaRepository<ParentComment,Long> {

    List<ParentComment> findAllByPostId(String postId);

    @Query(value = "SELECT parent.* FROM balance_vote_database.parent_comment parent LEFT OUTER JOIN balance_vote_database.child_comment child ON child.parent_id = parent.id ORDER BY time_stamp DESC", nativeQuery = true)
    List<ParentComment> findUserComments(String uuid);

    List<ParentComment> findAllByUuid(String uuid);
}
