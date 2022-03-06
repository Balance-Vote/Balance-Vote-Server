package com.BalanceVote.BalanceVoteServer.contorller;


import com.BalanceVote.BalanceVoteServer.dto.ParentCommentForm;
import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import com.BalanceVote.BalanceVoteServer.repository.ParentCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Rest api annotation
@Slf4j // logging anotation
public class CommentController {
    @Autowired
    private ParentCommentRepository parentCommentRepository;

    @GetMapping("/comment/get-post-parent-comment/{postId}")
    public List<ParentComment> getPostParentComment(@PathVariable String postId){
        return parentCommentRepository.findAllByPostId(postId);
    }

    @PostMapping("/comment/create-parent-comment")
    public ParentComment addParentComment(@RequestBody ParentCommentForm dto){
        ParentComment parentComment = dto.toEntity();
        log.info(parentComment.toString());
        ParentComment savedParentComment = parentCommentRepository.save(parentComment);
        return savedParentComment;
    }
}
