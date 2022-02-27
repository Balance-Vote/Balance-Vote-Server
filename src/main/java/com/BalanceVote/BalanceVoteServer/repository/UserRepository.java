package com.BalanceVote.BalanceVoteServer.repository;

import com.BalanceVote.BalanceVoteServer.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
/**
 * User Repositiory extending CrudRepository
 * @author JunmanChoi
 */
public interface UserRepository extends CrudRepository<User,Long> {
    @Override
    ArrayList<User> findAll(); // Overrided to changed data type of findAll(Iterable -> ArrayList)
}
