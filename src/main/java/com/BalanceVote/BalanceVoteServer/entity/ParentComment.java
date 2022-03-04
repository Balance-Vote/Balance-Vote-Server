package com.BalanceVote.BalanceVoteServer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Parent Comment Entity
 * @author JunmanChoi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "parent_comment")
public class ParentComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using Auto-increment in mysql to generate id
    private Long id;

    @Column(name="cmt_text")
    private String cmtText;
    @Column(name = "time_stamp")
    private String timeStamp;
    @Column(name = "like_cnt")
    private Integer likeCnt;
    @Column(name = "post_id")
    private String postId;
    @Column(name = "uuid")
    private String uuid;

}
