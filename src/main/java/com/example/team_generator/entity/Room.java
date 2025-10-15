package com.example.team_generator.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

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
    private int teamSize; // 팀 크기 (DB에 저장됨)

    @Column(columnDefinition = "TEXT")
    private String members; // 랜덤 순서로 배치된 문자열 (예: "철수,영희,민수")

    public Room(String teamName, int teamSize) {
        this.teamName = teamName;
        this.teamSize = teamSize;
        this.members = ""; // 초기엔 빈 문자열
    }

    // Getter
    public UUID getRoomId() {
        return roomId;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public String getMembers() {
        return members;
    }

    /**
     * 랜덤 순서로 섞은 후 문자열로 저장
     */
    public void updateMembers(List<String> memberList) {
        Collections.shuffle(memberList);
        this.members = String.join(",", memberList);
    }
}
