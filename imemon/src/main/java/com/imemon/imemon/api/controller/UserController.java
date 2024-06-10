package com.imemon.imemon.api.controller;

import com.imemon.imemon.ImemonApplication;
import com.imemon.imemon.api.model.User;
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

    private String createSession(User user){
        String session = java.util.UUID.randomUUID().toString();
        while(ImemonApplication.loggedUsers.get(session) != null){
            session = java.util.UUID.randomUUID().toString();
        }
        ImemonApplication.loggedUsers.put(session, user);
        return session;
    }

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/account/login")
    public UserResponse getUser(@RequestParam LoginRequest loginRequest) {

        try{
            User check = userRepository.findByEmail(loginRequest.getEmail());
            if (check != null) {
                if (loginRequest.getPassword().equals(check.getPassword())) {
                    String session = createSession(check);
                    return new UserResponse(200, "Succeccfully logged in", check.getUsername(), session);
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
    public UserResponse createUser(@RequestBody RegisterRequest registerRequest) {
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
            return new UserResponse(500, "server error", null, null);
        }
    }

    @PostMapping("/account/logoff")
    public SimpleResponse logoutUser(@RequestParam AuthRequest request) {
        try {
            if (ImemonApplication.loggedUsers.containsKey(request.getSession())) {
                ImemonApplication.loggedUsers.remove(request.getSession());
            }
        return new SimpleResponse(200, "Succeccfully logged out");
        }
        catch(Exception e){
            return new SimpleResponse(200, "Succeccfully logged out");
        }
    }

}
