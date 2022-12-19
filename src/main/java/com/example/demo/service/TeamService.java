package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;


    public List<Team> getTeams(){
        return teamRepository.findAll();
    }
    public List<Team> createTeam(List<Team> toCreate){
        List<Team> teams = teamRepository.saveAll(toCreate);
        return teams;
    }
    public List<Team>updateTeam(List<Team> toUpdate){
        return teamRepository.saveAll(toUpdate);
    }
    public Team deleteTeam(Long id){
        Optional<Team> teams2 = teamRepository.findById(id);
        if(teams2.isPresent()){
            teamRepository.delete(teams2.get());
            return teams2.get();
        }
        return null;
    }
}
