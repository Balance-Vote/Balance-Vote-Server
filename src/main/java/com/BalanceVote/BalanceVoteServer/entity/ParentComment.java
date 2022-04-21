package com.BalanceVote.BalanceVoteServer.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "1",value = "부모 댓글 아이디 (PK/Auto-implement)")
    private Long id;

    @Column(name="cmt_text")
    @ApiModelProperty(example = "댓글 내용~",value = "댓글 내용")
    private String cmtText;
    @Column(name = "time_stamp")
    @ApiModelProperty(example = "22년 03월 04일 11:36",value = "작성 시각")
    private String timeStamp;
    @Column(name = "like_cnt")
    @ApiModelProperty(example = "100",value = "좋아요 수")
    private Integer likeCnt;
    @Column(name = "post_id")
    @ApiModelProperty(example = "1",value = "게시글 ID")
    private Long postId;
    @Column(name = "uuid")
    @ApiModelProperty(example = "junman95",value = "범용 고유 식별자")
    private String uuid;

}
