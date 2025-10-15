package com.example.team_generator.controller;

import com.example.team_generator.dto.RoomCreateRequest;
import com.example.team_generator.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    /**
     * 방 생성
     */
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createRoom(@RequestBody RoomCreateRequest request) {
        UUID roomId = roomService.createRoom(request);
        return ResponseEntity.ok(Map.of("roomId", roomId.toString()));
    }

    // 방 조회
    @GetMapping
    public ResponseEntity<RoomResponse> getRoom(@RequestParam UUID id) {
        RoomResponse response = roomService.getRoom(id);
        return ResponseEntity.ok(response);
    }

}

