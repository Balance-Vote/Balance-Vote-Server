package com.BalanceVote.BalanceVoteServer.entity;

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
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using Auto-increment in mysql to generate id
    private Long id;

    @Column(name = "nickname") // Better specify column name in order to bind db table column as well
    private String nickname;
    @Column(name = "uuid") // Should convert to auto generation
    private String uuid;
}
