package com.BalanceVote.BalanceVoteServer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Vote Position Entity
 * @author JunmanChoi
 * @author DongGeon Lee
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vote_pos")
public class VotePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using Auto-increment in mysql to generate id
    private Long id;

    @Column(name="selected_pos")
    private String selected_pos;
    @Column(name = "post_id")
    private String postId;
    @Column(name = "uuid")
    private String uuid;
}
