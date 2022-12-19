package com.example.demo.mapper;

import com.example.demo.model.Team;
import com.example.demo.responses.CreateResponses;
import com.example.demo.responses.TeamResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamMapper {
    private final PlayMapper playMapper;

    public TeamResponse toRest(Team domain){
        return TeamResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .players(domain.getPlayers().stream().map(playMapper::toRest).toList())
                .build();
    }
    public Team toDomain(CreateResponses domain){
        return Team.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }
    public Team toUpdate(TeamResponse domain){
        return Team.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }
}
