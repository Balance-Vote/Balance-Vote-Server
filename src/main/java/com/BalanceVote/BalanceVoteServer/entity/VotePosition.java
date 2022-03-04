package com.BalanceVote.BalanceVoteServer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Vote Position Entity
 * @author JunmanChoi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vote_position")
public class VotePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using Auto-increment in mysql to generate id
    private Long id;

    @Column(name="selection_1")
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
