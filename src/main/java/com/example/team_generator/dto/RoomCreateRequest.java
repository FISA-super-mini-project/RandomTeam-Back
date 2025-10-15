package com.example.team_generator.dto;

import lombok.Getter;

@Getter
public class RoomCreateRequest {
    private String teamName;
    private int teamSize;
}