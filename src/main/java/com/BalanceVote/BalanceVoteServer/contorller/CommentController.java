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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/comment/get-comment/parent/post-id/{postId}")
    public List<ParentComment> getPostParentComment(@PathVariable String postId){
        return parentCommentRepository.findAllByPostId(postId);
    }

    @GetMapping("/comment/get-comment/all/user/{uuid}")
    public List getUserParentComment(@PathVariable String uuid){
        List<ParentComment> parentComments = parentCommentRepository.findAllByUuid(uuid);
        List<ChildComment> childComments = childCommentRepository.findAllByUuid(uuid);
        ArrayList allComments = new ArrayList<>();
        allComments.addAll(parentComments);
        allComments.addAll(childComments);
        return allComments;
    }

    @PostMapping("/comment/create-comment/parent")
    public ParentComment addParentComment(@RequestBody ParentCommentForm dto){
        ParentComment parentComment = dto.toEntity();
        log.info(parentComment.toString());
        ParentComment savedParentComment = parentCommentRepository.save(parentComment);
        return savedParentComment;
    }

    @PostMapping("/comment/create-comment/child")
    public ChildComment addChildComment(@RequestBody ChildCommentForm dto){
        ChildComment childComment = dto.toEntity();
        ChildComment savedChildComment = childCommentRepository.save(childComment);
        return savedChildComment;
    }
}
