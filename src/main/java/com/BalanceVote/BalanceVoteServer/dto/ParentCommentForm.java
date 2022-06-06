package com.BalanceVote.BalanceVoteServer.dto;

import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Parent Comment DTO
 * @author JunmanChoi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentCommentForm {
    @ApiModelProperty(example = "댓글 내용~", value = "댓글 내용",required = true)
    private String cmtText;
    @ApiModelProperty(hidden = true)
    private String timeStamp;
    @ApiModelProperty(hidden = true)
    private Integer likeCnt;
    @ApiModelProperty(example = "1", value = "게시물 ID",required = true)
    private String postId;
    @ApiModelProperty(example = "junman95", value = "범용 고유 식별자",required = true)
    private String uuid;
    /**
     * Converts data into ParentComment object
     */
    public ParentComment toEntity(){
        if(timeStamp == null){
            LocalDateTime now = LocalDateTime.now();
            timeStamp = now.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 hh:mm"));
        }
        if(likeCnt == null){ // On first addition
            likeCnt = 0;
        }
        return new ParentComment(null,cmtText,timeStamp,likeCnt,postId,uuid);
    }
}
