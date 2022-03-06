package com.BalanceVote.BalanceVoteServer.dto;

import com.BalanceVote.BalanceVoteServer.entity.ChildComment;
import com.BalanceVote.BalanceVoteServer.entity.ParentComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildCommentForm {
    private String cmtText;
    private String timeStamp;
    private Integer likeCnt;
    private String parentCmtId;
    private String postId;
    private String uuid;

    public ChildComment toEntity(){
        if(timeStamp == null){
            LocalDateTime now = LocalDateTime.now();
            timeStamp = now.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 hh:mm"));
        }
        if(likeCnt == null){ // On first addition
            likeCnt = 0;
        }
        return new ChildComment(null,cmtText,timeStamp,likeCnt,parentCmtId,postId,uuid);
    }
}
