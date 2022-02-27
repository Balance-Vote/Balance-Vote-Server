package com.BalanceVote.BalanceVoteServer.contorller;

import com.BalanceVote.BalanceVoteServer.dto.UserForm;
import com.BalanceVote.BalanceVoteServer.entity.User;
import com.BalanceVote.BalanceVoteServer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User Controller
 * @author JunmanChoi
 */
@RestController // Rest api annotation
@Slf4j // logging anotation
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * Search all user informations
     * @param None
     * @return List : List of User
     */
    @GetMapping("/user/get-user")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Search specific user via id
     * @param Id : Long or Int type
     * @return User
     */
    @GetMapping("/user/get-user/{id}")
    public User getUser(@PathVariable Long id){

        log.info("id searched : {} ",id);
        User searchedUser = userRepository.findById(id).orElse(null);
        return searchedUser;
    }

    /**
     * Create user
     * @param UserForm
     * @return User
     */
    @PostMapping("/user/create-user")
    public User createUser(@RequestBody UserForm dto){
        log.info(dto.toString());
        User user = dto.toEntity(); //get a user object without id
        log.info(user.toString());
        User savedUser = userRepository.save(user); // assign user id and save it into database
        return savedUser;
    }
}
