package com.imemon.imemon.api.controller;

import com.imemon.imemon.ImemonApplication;
import com.imemon.imemon.api.model.LoggedUsers;
import com.imemon.imemon.api.model.User;
import com.imemon.imemon.api.repository.LoggedUsersRepository;
import com.imemon.imemon.api.repository.UserRepository;
import com.imemon.imemon.api.requests.AuthRequest;
import com.imemon.imemon.api.requests.LoginRequest;
import com.imemon.imemon.api.requests.RegisterRequest;
import com.imemon.imemon.api.responses.SimpleResponse;
import com.imemon.imemon.api.responses.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserRepository userRepository;
    private LoggedUsersRepository loggedUsersRepository;

    private String createSession(User user){
        String session = java.util.UUID.randomUUID().toString();
        while(loggedUsersRepository.existsBySession(session)){
            session = java.util.UUID.randomUUID().toString();
        }
        loggedUsersRepository.save(new LoggedUsers(session, user.getUsername()));
        return session;
    }

    public UserController(UserRepository userRepository, LoggedUsersRepository loggedUsersRepository) {
        this.userRepository = userRepository;
        this.loggedUsersRepository = loggedUsersRepository;
    }

    @PostMapping("/account/login")
    public UserResponse getUser(LoginRequest loginRequest) {

        System.out.println(loginRequest.getEmail());

        try{
            User check = userRepository.findByEmail(loginRequest.getEmail());
            if (check != null) {
                if (loginRequest.getPassword().equals(check.getPassword())) {
                    String session = createSession(check);
                    return new UserResponse(200, "Successfully logged in", check.getUsername(), session);
                }
                else{
                    return new UserResponse(401, "Incorrect email or password", null, null);
                }
            }
            else{
                return new UserResponse(401, "Incorrect email or password", null, null);
            }
        }
        catch(Exception e){
            return new UserResponse(500, "server error", null, null);
        }

    }

    @PostMapping("/account/register")
    public UserResponse createUser(RegisterRequest registerRequest) {
        try{
            if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
                return new UserResponse(409, "User already exists", null, null);
                //user already exists
            }
            else{
                User user = new User(registerRequest);
                userRepository.save(user);
                String session = createSession(user);
                return new UserResponse(200, "Succeccfully registered in", registerRequest.getUsername(), session);
                // added user
            }
        }
        catch(Exception e){
            System.out.println(e);
            return new UserResponse(500, "server error", null, null);
        }
    }

    @PostMapping("/account/logoff")
    public SimpleResponse logoutUser(AuthRequest request) {
        try {
            if (loggedUsersRepository.existsBySession(request.getSession())) {
                loggedUsersRepository.deleteBySession(request.getSession());
            }
        return new SimpleResponse(200, "Succeccfully logged out");
        }
        catch(Exception e){
            return new SimpleResponse(200, "Succeccfully logged out");
        }
    }

}
