package com.example.demo.responses;

import com.example.demo.model.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeamResponse {
    private long id;
    private String name;
    private List<Player> players;

}
