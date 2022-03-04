package com.BalanceVote.BalanceVoteServer.contorller;

import java.util.List;

import com.BalanceVote.BalanceVoteServer.entity.VotePost;
import com.BalanceVote.BalanceVoteServer.repository.VotePostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class VoteController {
    
    @Autowired
    private VotePostRepository votePostRepository;

    /**
     * Search all vote posts.
     * @author DongGeon Lee
     */
    @GetMapping("/post/vote-post")
    public Page<VotePost> getAllVotePost(Pageable pageable){
        return votePostRepository.findAll(pageable);
    }

    /**
     * Get most voted posts in Desc order.
     * @author DongGeon Lee
     */
    @GetMapping("/post/most-voted")
    public List<VotePost> getMostVotedPostinPeriod(int count){
        if (count < 1) {
            count = 1;
        }
        return votePostRepository.findtwetgweg(count);
    }
}
