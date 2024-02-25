package com.example.CRUDintuit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Table(name = "PLAYERS_TABLE")
@Entity
@NoArgsConstructor
@Setter
@ToString
@Data
public class Player {
    @Id
    private String playerID;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private int deathYear;
    private int deathMonth;
    private int deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private int weight;
    private int height;
    private String bats;
    private String throwss;
    private String debut;
    private String finalGame;
    private String retroID;
    private String bbrefID;

    public Player(String playerID, int birthYear, int birthMonth, int birthDay, String birthCountry, String birthState, String birthCity,
                  int deathYear, int deathMonth, int deathDay, String deathCountry, String deathState, String deathCity,
                  String nameFirst, String nameLast, String nameGiven, int weight, int height, String bats, String throwss,
                  String debut, String finalGame, String retroID, String bbrefID) {
        this.playerID = playerID;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthCountry = birthCountry;
        this.birthState = birthState;
        this.birthCity = birthCity;
        this.deathYear = deathYear;
        this.deathMonth = deathMonth;
        this.deathDay = deathDay;
        this.deathCountry = deathCountry;
        this.deathState = deathState;
        this.deathCity = deathCity;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.nameGiven = nameGiven;
        this.weight = weight;
        this.height = height;
        this.bats = bats;
        this.throwss = throwss;
        this.debut = debut;
        this.finalGame = finalGame;
        this.retroID = retroID;
        this.bbrefID = bbrefID;
    }
    public String getPlayerID(){
        return this.playerID;
    }
}
