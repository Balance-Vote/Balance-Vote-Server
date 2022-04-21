package com.BalanceVote.BalanceVoteServer.contorller;

import com.BalanceVote.BalanceVoteServer.dto.UserForm;
import com.BalanceVote.BalanceVoteServer.entity.User;
import com.BalanceVote.BalanceVoteServer.repository.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "유저 목록 조회", notes = "전체 유저 목록 조회")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Search specific user via id
     * @param Id : Long or Int type
     * @return User
     */
    @GetMapping("/user/get-user/{id}")
    @ApiOperation(value = "특정 유저 조회", notes = "ID값에 따른 특정 유저 정보 조회")
    @ApiImplicitParam(name="id", required = true,value = "사용자 ID",dataType = "int")
    public User getUser(@PathVariable(name="id") Long id){

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
    @ApiOperation(value = "유저 생성", notes = "유저 신규 생성")
    public User createUser(@RequestBody UserForm dto){
        log.info(dto.toString());
        User user = dto.toEntity(); //get a user object without id
        log.info(user.toString());
        User savedUser = userRepository.save(user); // assign user id and save it into database
        return savedUser;
    }
}
