//package com.example.CRUDintuit.util;
//
//import com.example.CRUDintuit.controller.PlayerController;
//import com.example.CRUDintuit.entity.Player;
//import com.example.CRUDintuit.repository.PlayerRepository;
//import com.example.CRUDintuit.service.PlayerService;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.FileReader;
//
//public class CSVParser {
//
//    public void parseCSVAndInsertToDB(String filePath) {
//
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            br.readLine(); // read and the discard the first line
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] data = line.split(",", -1); // Assuming CSV is comma-separated
//                String playerID = data[0];
//                int birthYear = (data[1].isEmpty()) ? 0 :Integer.parseInt(data[1]);
//                int birthMonth = (data[2].isEmpty()) ? 0 :Integer.parseInt(data[2]);
//                int birthDay = (data[3].isEmpty()) ? 0 :Integer.parseInt(data[3]);
//                String birthCountry = data[4];
//                String birthState = data[5];
//                String birthCity = data[6];
//                int deathYear = (data[7].isEmpty()) ? 0 : Integer.parseInt(data[7]);
//                int deathMonth = (data[8].isEmpty()) ? 0 : Integer.parseInt(data[8]);
//                int deathDay = (data[9].isEmpty()) ? 0 : Integer.parseInt(data[9]);
//                String deathCountry = data[10];
//                String deathState = data[11];
//                String deathCity = data[12];
//                String nameFirst = data[13];
//                String nameLast = data[14];
//                String nameGiven = data[15];
//                int weight = (data[16].isEmpty()) ? 0 : Integer.parseInt(data[16]);
//                int height = (data[17].isEmpty()) ? 0 : Integer.parseInt(data[17]);
//                String bats = data[18];
//                String throws_ = data[19];
//                String debut = data[20];
//                String finalGame = data[21];
//                String retroID = data[22];
//                String bbrefID = data[23];
//                Player player = new Player(
//                        playerID,
//                        birthYear,
//                        birthMonth,
//                        birthDay,
//                        birthCountry,
//                        birthState,
//                        birthCity,
//                        deathYear,
//                        deathMonth,
//                        deathDay,
//                        deathCountry,
//                        deathState,
//                        deathCity,
//                        nameFirst,
//                        nameLast,
//                        nameGiven,
//                        weight,
//                        height,
//                        bats,
//                        throws_,
//                        debut,
//                        finalGame,
//                        retroID,
//                        bbrefID
//                );
//                playerService.addPlayer(player);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//        public static void main(String[] args) {
//            // Instantiate necessary components
//            PlayerService playerService = new PlayerService();
//            CSVParser csvParser = new CSVParser(playerService);
//
//            // Provide the file path to your CSV file
//            String filePath = "CRUDintuit/src/main/resources/players.csv";
//
//            // Call parseCSVAndInsertToDB method
//            csvParser.parseCSVAndInsertToDB(filePath);
//    }
//}
//
