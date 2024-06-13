package com.imemon.imemon.api.controller;

import com.imemon.imemon.ImemonApplication;
import com.imemon.imemon.api.model.LoggedUsers;
import com.imemon.imemon.api.model.Team;
import com.imemon.imemon.api.repository.LoggedUsersRepository;
import com.imemon.imemon.api.repository.TeamRepository;
import com.imemon.imemon.api.requests.AuthRequest;
import com.imemon.imemon.api.requests.TeamRequest;
import com.imemon.imemon.api.responses.SimpleResponse;
import com.imemon.imemon.api.responses.TeamResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TeamController {
    private TeamRepository teamRepository;
    private LoggedUsersRepository loggedUsersRepository;

    public TeamController(TeamRepository teamRepository, LoggedUsersRepository loggedUsersRepository) {
        this.teamRepository = teamRepository;
        this.loggedUsersRepository = loggedUsersRepository;
    }

    @PostMapping("/teams/retrieve")
    public TeamResponse retrieveTeams(AuthRequest request) {
        try{
            if(loggedUsersRepository.findBySession(request.getSession()).getUsername().equals(request.getUsername())){
                return new TeamResponse(200, "Returning teams", teamRepository.findAllByUsername(request.getUsername()));
            }
            else{
                return new TeamResponse(403, "not authenticated", null);
            }
        }
        catch(Exception e){
            return new TeamResponse(500, "server error", null);
        }
    }

    @PostMapping("/teams/delete/{teamId}")
    public SimpleResponse deleteTeams(AuthRequest request, @PathVariable long teamId) {
        try{
            if(loggedUsersRepository.findBySession(request.getSession()).getUsername().equals(request.getUsername())){
                if(teamRepository.findById(teamId).getUsername().equals(request.getUsername())) {
                    teamRepository.deleteById(teamId);
                    return new SimpleResponse(200, "Deleted Team");
                }
                else return new SimpleResponse(404, "no user team exists with this id");

            }
            else return new SimpleResponse(403, "not authenticated");
        }
        catch(Exception e){
            return new SimpleResponse(500, "server error");
        }
    }


    @PostMapping("teams/add")
    public SimpleResponse addTeam(TeamRequest request) {
        try{
            String session = request.getSession();
            if(loggedUsersRepository.findBySession(session).getUsername().equals(request.getUsername())){
                teamRepository.save(new Team(request));
                return new SimpleResponse(200, "Team added");
            }
            else return new SimpleResponse(403, "not authenticated");
        }
        catch(Exception e){
            return new SimpleResponse(500, "server error");
        }

    }

}
