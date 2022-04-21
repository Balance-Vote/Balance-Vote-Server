package com.BalanceVote.BalanceVoteServer.contorller;


import com.BalanceVote.BalanceVoteServer.dto.ChildCommentForm;
import com.BalanceVote.BalanceVoteServer.dto.ParentCommentForm;
import com.BalanceVote.BalanceVoteServer.entity.ChildComment;
import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import com.BalanceVote.BalanceVoteServer.repository.ChildCommentRepository;
import com.BalanceVote.BalanceVoteServer.repository.ParentCommentRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "포스트 댓글 조회", notes = "특정 포스트의 부모 댓글(1차댓글) 조회")
    @ApiImplicitParam(name="postId", required = true,value = "게시물 ID",dataType = "int")
    public List<ParentComment> getPostParentComment(@PathVariable String postId){
        return parentCommentRepository.findAllByPostId(postId);
    }
    /**
     * Get all comments that are under current user
     * @param uuid
     * pathVariable that comes from url
     */
    @GetMapping("/comment/get-comment/all/user/{uuid}")
    @ApiOperation(value = "유저 댓글 조회", notes = "특정 유저의 모든 댓글 조회(시간순)")
    @ApiImplicitParam(name="uuid", required = true,value = "사용자 범용식별 ID",dataType = "string")
    public List<ParentComment> getUserComment(@PathVariable String uuid){
        List<ParentComment> userComments = parentCommentRepository.findUserComments(uuid);
        return userComments;
    }
    /**
     * Get all comments that are under current parentCmtId
     * @param parentCmtId
     * pathVariable that comes from url
     */
    @GetMapping("/comment/get-comment/child/parent-id/{parentCmtId}")
    @ApiOperation(value = "대댓글 조회", notes = "특정 부모 댓글(1차 댓글)의 자식 댓글(대댓글) 조회")
    @ApiImplicitParam(name="parentCmtId", required = true,value = "부모 댓글 ID",dataType = "int")
    public List<ChildComment> getChildComment(@PathVariable String parentCmtId){
        List<ChildComment> childComments = childCommentRepository.findAllByParentCmtId(parentCmtId);
        return childComments;
    }
    /**
     * Create a parent-comment
     * @param dto
     * parent comment form data
     */
    @PostMapping("/comment/create-comment/parent")
    @ApiOperation(value = "부모 댓글 생성", notes = "부모 댓글(댓글) 생성")
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
    @ApiOperation(value = "자식 댓글 생성", notes = "자식 댓글(대댓글) 생성")
    public ChildComment addChildComment(@RequestBody ChildCommentForm dto){
        ChildComment childComment = dto.toEntity();
        ChildComment savedChildComment = childCommentRepository.save(childComment);
        return savedChildComment;
    }
}
