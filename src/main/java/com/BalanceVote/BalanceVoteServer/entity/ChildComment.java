package com.BalanceVote.BalanceVoteServer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Child Comment Entity
 * @author JunmanChoi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "child_comment")
public class ChildComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using Auto-increment in mysql to generate id
    private Long id;

    @Column(name="cmt_text")
    private String cmtText;
    @Column(name = "time_stamp")
    private String timeStamp;
    @Column(name = "like_cnt")
    private Integer likeCnt;
    @Column(name = "parent_id")
    private String parentId;
    @Column(name = "uuid")
    private String uuid;
}
