package com.example.team_generator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class RoomResponse {
    private UUID roomId;
    private String teamName;
    private int teamSize;
    private String members;
}