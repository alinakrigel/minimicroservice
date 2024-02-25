package com.example.CRUDintuit.controller;

import com.example.CRUDintuit.entity.Player;
import com.example.CRUDintuit.repository.PlayerRepository;
import com.example.CRUDintuit.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/api/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return playerService.getAllPlayers();
    }
    @GetMapping("/api/players/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        return playerService.getPlayerById(id);
    }
    @PostMapping("/api/addPlayer")
    public ResponseEntity<Player> addPlayer (@RequestBody Player player) {

        return playerService.addPlayer(player);
    }
    @PostMapping("api/players/createAll")
    public ResponseEntity<String> createDbWithPlayers() {
        String filePath = "CRUDintuit/src/main/resources/players.csv";
        return playerService.createDbWithPlayers(filePath);
    }


    // optional - add delete and update player
}
