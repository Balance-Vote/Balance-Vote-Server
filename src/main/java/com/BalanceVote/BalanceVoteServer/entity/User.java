package com.BalanceVote.BalanceVoteServer.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * User Entity(Model)
 * @author JunmanChoi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using Auto-increment in mysql to generate id
    @ApiModelProperty(example = "1",value = "유저 아이디 (PK/Auto-implement)")
    private Long id;

    @Column(name = "nickname") // Better specify column name in order to bind db table column as well
    @ApiModelProperty(example = "DONGGUNNI",value = "유저 닉네임")
    private String nickname;
    @Column(name = "uuid",unique = true) // Should convert to auto generation
    @ApiModelProperty(example = "junman95",value = "범용 고유 식별자")
    private String uuid;
}
