package com.BalanceVote.BalanceVoteServer.contorller;


import com.BalanceVote.BalanceVoteServer.dto.ParentCommentForm;
import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import com.BalanceVote.BalanceVoteServer.repository.ParentCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // Rest api annotation
@Slf4j // logging anotation
public class CommentController {
    @Autowired
    private ParentCommentRepository parentCommentRepository;

    @PostMapping("/comment/create-parent-comment")
    public ParentComment addParentComment(@RequestBody ParentCommentForm dto){
        ParentComment parentComment = dto.toEntity();
        log.info(parentComment.toString());
        ParentComment savedParentComment = parentCommentRepository.save(parentComment);
        return savedParentComment;
    }
}
