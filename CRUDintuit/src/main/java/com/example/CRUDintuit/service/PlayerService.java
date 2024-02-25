/*** this class purpose is to communicate with DB
 playerController will hold an instance of this class and apply the given methods
 no other class is allowed to because it's important to keep data save
 and centralized for future features addition ***/

package com.example.CRUDintuit.service;
import com.example.CRUDintuit.entity.Player;
import com.example.CRUDintuit.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // returns a list of all players in db
    public ResponseEntity<List<Player>> getAllPlayers() {
        try {
            List<Player> playersList = new ArrayList<>();
            playerRepository.findAll().forEach(playersList::add);

            if(playersList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(playersList,HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // return a specific player from db by unique id
    public ResponseEntity<Player> getPlayerById(String id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()) {
            return new ResponseEntity<>(player.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // creates a new player record and adds it to db
    public ResponseEntity<Player> addPlayer (Player player) {
        Player playerObj = playerRepository.save(player);
        return new ResponseEntity<>(playerObj, HttpStatus.OK);
    }
    // reads csv player records file and create a player object to each record
    // to insert to db. insertion is done to a list of players for efficiency
    public ResponseEntity<String> createDbWithPlayers(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // read and the discard the first line
            String line;
            List<Player> playersList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", -1); // Assuming CSV is comma-separated
                String playerID = data[0];
                int birthYear = (data[1].isEmpty()) ? 0 :Integer.parseInt(data[1]);
                int birthMonth = (data[2].isEmpty()) ? 0 :Integer.parseInt(data[2]);
                int birthDay = (data[3].isEmpty()) ? 0 :Integer.parseInt(data[3]);
                String birthCountry = data[4];
                String birthState = data[5];
                String birthCity = data[6];
                int deathYear = (data[7].isEmpty()) ? 0 : Integer.parseInt(data[7]);
                int deathMonth = (data[8].isEmpty()) ? 0 : Integer.parseInt(data[8]);
                int deathDay = (data[9].isEmpty()) ? 0 : Integer.parseInt(data[9]);
                String deathCountry = data[10];
                String deathState = data[11];
                String deathCity = data[12];
                String nameFirst = data[13];
                String nameLast = data[14];
                String nameGiven = data[15];
                int weight = (data[16].isEmpty()) ? 0 : Integer.parseInt(data[16]);
                int height = (data[17].isEmpty()) ? 0 : Integer.parseInt(data[17]);
                String bats = data[18];
                String throws_ = data[19];
                String debut = data[20];
                String finalGame = data[21];
                String retroID = data[22];
                String bbrefID = data[23];
                Player player = new Player(
                        playerID,
                        birthYear,
                        birthMonth,
                        birthDay,
                        birthCountry,
                        birthState,
                        birthCity,
                        deathYear,
                        deathMonth,
                        deathDay,
                        deathCountry,
                        deathState,
                        deathCity,
                        nameFirst,
                        nameLast,
                        nameGiven,
                        weight,
                        height,
                        bats,
                        throws_,
                        debut,
                        finalGame,
                        retroID,
                        bbrefID
                );
                playersList.add(player);
            }
            playerRepository.saveAll(playersList);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    }

    // optional - add delete and update player

