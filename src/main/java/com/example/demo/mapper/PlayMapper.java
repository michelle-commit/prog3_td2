package com.example.demo.mapper;

import com.example.demo.model.Player;
import com.example.demo.responses.PlayerResponse;
import org.springframework.stereotype.Component;

@Component
public class PlayMapper {
    public PlayerResponse toRest(Player domain){
        return PlayerResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .firstname(domain.getFirstname())
                .build();
    }
}
