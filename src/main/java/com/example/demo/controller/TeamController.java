package com.example.demo.controller;

import com.example.demo.mapper.TeamMapper;
import com.example.demo.model.Team;
import com.example.demo.responses.CreateResponses;
import com.example.demo.responses.TeamResponse;
import com.example.demo.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;
    @GetMapping(value = "/team")
    public List<TeamResponse> getTeam(){
       return teamService.getTeams().stream()
               .map(teamMapper::toRest).toList();
    }
    @PostMapping(value = "/team")
    public List<TeamResponse> creatTeam(@RequestBody List<CreateResponses> toCreate){
        List<Team> teams = toCreate.stream().map(teamMapper::toDomain).toList();
        return teamService.createTeam(teams).stream()
                .map(teamMapper::toRest)
                .toList();
    }
    @PutMapping(value = "/team")
    public List<TeamResponse> toUpdateTeam(@RequestBody List<TeamResponse> toUpdate){
        List<Team> teams1 = toUpdate.stream().map(teamMapper::toUpdate).toList();
        return teamService.updateTeam(teams1).stream().map(teamMapper::toRest).toList();
    }
    @DeleteMapping(value = "/team/{id}")
    public TeamResponse deleteUpdate(@PathVariable Long id){
        return teamMapper.toRest(teamService.deleteTeam(id));
    }
}
