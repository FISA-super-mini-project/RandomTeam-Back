package com.example.team_generator.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Entity
@Table(name = "room")
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "room_id", columnDefinition = "BINARY(16)")
    private UUID roomId; // 방 UUID (프론트에서 사용)

    @Column(nullable = false)
    private String teamName; // 방 이름

    @Column(nullable = false)
    private int totalMembers; // 전체 인원 수

    @Column(nullable = false)
    private int teamSize; // 팀 크기

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "room_members", joinColumns = @JoinColumn(name = "room_id"))
    @Column(name = "member_name")
    private List<String> members = new ArrayList<>();

    public Room(String teamName, int totalMembers, int teamSize) {
        this.teamName = teamName;
        this.totalMembers = totalMembers;
        this.teamSize = teamSize;
        this.members = new ArrayList<>(Collections.nCopies(totalMembers, "")); // "" 초기화
    }

    // Getter
    public UUID getRoomId() {
        return roomId;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public List<String> getMembers() {
        return members;
    }

    public void updateMembers(List<String> members) {
        this.members = members;
    }
}
