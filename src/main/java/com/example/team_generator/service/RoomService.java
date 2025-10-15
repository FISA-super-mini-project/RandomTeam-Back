package com.example.team_generator.service;

import com.example.team_generator.dto.RoomCreateRequest;
import com.example.team_generator.dto.RoomResponse;
import com.example.team_generator.entity.Room;
import com.example.team_generator.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    /**
     * 방 생성
     */
    public UUID createRoom(RoomCreateRequest request) {
        Room room = new Room(request.getTeamName(), request.getTeamSize());
        roomRepository.save(room);
        return room.getRoomId();
    }

    // 방 조회
    public RoomResponse getRoom(UUID roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new NoSuchElementException("해당 roomId를 찾을 수 없습니다."));

        return new RoomResponse(
                room.getRoomId(),
                room.getTeamName(),
                room.getTeamSize(),
                room.getMembers()
        );
    }

    // 랜덤배치
    public String randomAssign(UUID roomId, List<String> members) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new NoSuchElementException("해당 roomId를 찾을 수 없습니다."));

        room.updateMembers(members);
        roomRepository.save(room);

        return room.getMembers(); // 랜덤 순서 문자열 반환
    }
}
