package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * ParentComment Repositiory extending CrudRepository
 * @author JunmanChoi
 */
public interface ParentCommentRepository extends JpaRepository<ParentComment,Long> {

    @Query(value = "SELECT parent.* FROM balance_vote_database.parent_comment parent WHERE parent.post_id = :postId ORDER BY time_stamp DESC", nativeQuery = true)
    List<ParentComment> findAllByPostId(@Param(value = "postId") String postId);

    @Query(value = "SELECT parent.* FROM balance_vote_database.parent_comment parent LEFT OUTER JOIN balance_vote_database.child_comment child ON child.parent_id = parent.id WHERE parent.uuid = :uuid ORDER BY time_stamp DESC", nativeQuery = true)
    List<ParentComment> findUserComments(@Param(value = "uuid") String uuid);

    List<ParentComment> findAllByUuid(String uuid);

    @Query(value = "SELECT parent.post_id FROM balance_vote_database.parent_comment parent LEFT OUTER JOIN balance_vote_database.child_comment child ON child.parent_id = parent.id GROUP BY parent.post_id ORDER BY COUNT(parent.id) DESC LIMIT 1", nativeQuery = true)
    String findPostIdByCommentCount();
}
