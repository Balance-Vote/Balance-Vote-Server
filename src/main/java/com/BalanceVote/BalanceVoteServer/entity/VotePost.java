package com.BalanceVote.BalanceVoteServer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Vote Position Entity
 * @author DongGeon Lee
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vote_post")
public class VotePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using Auto-increment in mysql to generate id
    private Long id;

    @Column(name = "selection_1")
    private String selectionOne;
    @Column(name = "selection_2")
    private String selectionTwo;
    @Column(name = "vote_cnt_1")
    private Integer voteCntOne;
    @Column(name = "vote_cnt_2")
    private Integer voteCntTwo;
    @Column(name = "post_id")
    private String postId;
    @Column(name = "uuid")
    private String uuid;
}
