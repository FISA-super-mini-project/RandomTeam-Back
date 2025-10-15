package com.example.team_generator.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RandomAssignRequest {
    private List<String> members;
}