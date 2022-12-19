package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayAgainst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime datetime;
    private String stadium;
    private Long id_opposons_team;
    @ManyToOne
    private Team opposonsTeam;
    private Long id_adversaire_team;
    @ManyToOne
    private Team adversaireTeam;
}
