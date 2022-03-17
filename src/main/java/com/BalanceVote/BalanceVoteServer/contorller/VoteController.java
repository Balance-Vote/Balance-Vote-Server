package com.BalanceVote.BalanceVoteServer.contorller;

import java.util.List;

import com.BalanceVote.BalanceVoteServer.dto.VotePositionForm;
import com.BalanceVote.BalanceVoteServer.dto.VotePostCreateForm;
import com.BalanceVote.BalanceVoteServer.entity.VotePosition;
import com.BalanceVote.BalanceVoteServer.entity.VotePost;
import com.BalanceVote.BalanceVoteServer.repository.ParentCommentRepository;
import com.BalanceVote.BalanceVoteServer.repository.VotePositionRepository;
import com.BalanceVote.BalanceVoteServer.repository.VotePostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class VoteController {
    
    @Autowired
    private VotePostRepository votePostRepository;
   
    @Autowired
    private VotePositionRepository votePositionRepository;
   
    @Autowired
    private ParentCommentRepository parentCommentRepository;

    /**
     * Search all vote posts.
     * @author DongGeon Lee
     */
    @GetMapping("/post/vote-post")
    public Page<VotePost> getAllVotePost(String postId, Pageable pageable){
        return votePostRepository.findAll(pageable);
    }

    /**
     * Search vote post.
     * @author DongGeon Lee
     */
    @GetMapping("/post/vote-post/{postId}")
    public VotePost getVotePost(String postId){
        return votePostRepository.findByPostId(postId).orElse(null);
    }

    /**
     * Get most voted posts in Desc order.
     * @author DongGeon Lee
     */
    @GetMapping("/post/most-voted")
    public List<VotePost> getMostVotedPosting(int count){
        if (count < 1) {
            count = 1;
        }
        return votePostRepository.findAllByVoteCount(count);
    }

    /**
     * Get most commented posts in Desc order.
     * @author DongGeon Lee
     */
    @GetMapping("/post/most-commented")
    public VotePost getMostCommentedPosting(){
        String postId = parentCommentRepository.findPostIdByCommentCount();
        return votePostRepository.findByPostId(postId).orElse(null);
    }

    /**
     * Vote post.
     * @author DongGeon Lee
     */
    @PostMapping("/post/vote-post/{postId}")
    public Boolean votePost(String postId, @RequestBody VotePositionForm votePosition){
        VotePost vp = votePostRepository.findByPostId(postId).orElse(null);
        if (vp == null) {
            return false;
        }

        if(votePosition.getSelectedPos().equals("1")) {
            vp.setVoteCntOne(vp.getVoteCntOne() + 1);
        } else if(votePosition.getSelectedPos().equals("2")) {
            vp.setVoteCntTwo(vp.getVoteCntTwo() + 1);
        } else {
            return false;
        }
        votePostRepository.save(vp);

        VotePosition votePos = votePosition.toEntity();
        votePos.setPostId(postId);
        votePositionRepository.save(votePos);

        return true;
    }

    /**
     * Post new vote.
     * @author DongGeon Lee
     */
    @PostMapping("/post/vote-post")
    public String postNewVote(@RequestBody VotePostCreateForm newVoteForm){
        // TODO: verify uuid.
        VotePost voteToPost = newVoteForm.toEntity();
        // TODO: create new unique postid.
        voteToPost.setPostId(voteToPost.getUuid() + System.currentTimeMillis());
        String voteId = votePostRepository.save(voteToPost).getPostId();

        return voteId;
    }
}
