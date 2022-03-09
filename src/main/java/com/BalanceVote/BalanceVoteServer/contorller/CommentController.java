package com.BalanceVote.BalanceVoteServer.contorller;


import com.BalanceVote.BalanceVoteServer.dto.ChildCommentForm;
import com.BalanceVote.BalanceVoteServer.dto.ParentCommentForm;
import com.BalanceVote.BalanceVoteServer.entity.ChildComment;
import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import com.BalanceVote.BalanceVoteServer.repository.ChildCommentRepository;
import com.BalanceVote.BalanceVoteServer.repository.ParentCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Comment Controller
 * @author JunmanChoi
 */
@RestController // Rest api annotation
@Slf4j // logging anotation
public class CommentController {
    @Autowired
    private ParentCommentRepository parentCommentRepository;
    @Autowired
    private ChildCommentRepository childCommentRepository;
    /*
    Parent Comment CRUD methods
     */
    /**
     * Get all parent-comments that are under current post
     * @param postId
     * pathVariable that comes from url
     */
    @GetMapping("/comment/get-comment/parent/post-id/{postId}")
    public List<ParentComment> getPostParentComment(@PathVariable String postId){
        return parentCommentRepository.findAllByPostId(postId);
    }
    /**
     * Get all comments that are under current user
     * @param uuid
     * pathVariable that comes from url
     */
    @GetMapping("/comment/get-comment/all/user/{uuid}")
    public List<ParentComment> getUserParentComment(@PathVariable String uuid){
        List<ParentComment> userComments = parentCommentRepository.findUserComments(uuid);
        return userComments;
    }
    /**
     * Create a parent-comment
     * @param dto
     * parent comment form data
     */
    @PostMapping("/comment/create-comment/parent")
    public ParentComment addParentComment(@RequestBody ParentCommentForm dto){
        ParentComment parentComment = dto.toEntity();
        log.info(parentComment.toString());
        ParentComment savedParentComment = parentCommentRepository.save(parentComment);
        return savedParentComment;
    }
    /**
     * Create a child-comment
     * @param dto
     * child comment form data
     */
    @PostMapping("/comment/create-comment/child")
    public ChildComment addChildComment(@RequestBody ChildCommentForm dto){
        ChildComment childComment = dto.toEntity();
        ChildComment savedChildComment = childCommentRepository.save(childComment);
        return savedChildComment;
    }
}
