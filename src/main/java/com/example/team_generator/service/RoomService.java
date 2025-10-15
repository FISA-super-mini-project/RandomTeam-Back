package com.example.team_generator.service;

import com.example.team_generator.dto.RoomCreateRequest;
import com.example.team_generator.entity.Room;
import com.example.team_generator.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
