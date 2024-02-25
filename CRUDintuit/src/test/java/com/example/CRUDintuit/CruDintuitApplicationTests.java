package com.example.CRUDintuit;

import com.example.CRUDintuit.entity.Player;
import com.example.CRUDintuit.repository.PlayerRepository;
import com.example.CRUDintuit.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class CruDintuitApplicationTests {
	@Autowired
	private PlayerService playerService;

	@MockBean
	private PlayerRepository playerRepository;
	@Test
	// check quantity of records
	public void getPlayersQuaTest() {
		List<Player> pl = new ArrayList<>();
		pl.add(new Player
				("aardsda01", 1981,
						12, 27, "USA",
						"CO",  "Denver", 0,
						0, 0,  "russia",
						"petah-tikva", "petah-tikva",
						"David", "Aardsma",
						"David Allan", 215,
						75, "R", "R", "2004-04-06",
						"2015-08-23", "aardd001", "aardsda01"));
		pl.add(new Player
				("asdd2", 1965,
						11, 23, "USA",
						"CO",  "Denver", 0,
						0, 0,  "russia",
						"petah-tikva", "petah-tikva",
						"Ariel", "Aardsma",
						"David Allan", 215,
						75, "R", "R", "2006-05-06",
						"2014-08-23", "aardd001", "aardsda01"));
		when(playerRepository.findAll()).thenReturn(pl);
		assertEquals("check findall retrieves all data from db ",2,playerService.getAllPlayers().getBody().size());
	}
	@Test
	// check content of records
	// make this function to check all values not just id
	public void getPlayersConTest(){
		List<Player> pl = new ArrayList<>();
		pl.add(new Player
				("aardsda01", 1981,
						12, 27, "USA",
						"CO",  "Denver", 0,
						0, 0,  "russia",
						"petah-tikva", "petah-tikva",
						"David", "Aardsma",
						"David Allan", 215,
						75, "R", "R", "2004-04-06",
						"2015-08-23", "aardd001", "aardsda01"));

		when(playerRepository.findAll()).thenReturn(pl);
		Player player = playerService.getAllPlayers().getBody().get(0);
		assertEquals("check content","aardsda01",player.getPlayerID());

	}

	@Test
	// test getPlayerById content
	public void getPlayerByIdTest() {
		Player player = new Player
				("aardsda01", 1981,
						12, 27, "USA",
						"CO",  "Denver", 0,
						0, 0,  "russia",
						"petah-tikva", "petah-tikva",
						"David", "Aardsma",
						"David Allan", 215,
						75, "R", "R", "2004-04-06",
						"2015-08-23", "aardd001", "aardsda01");
		when(playerRepository.findById("aardsda01")).thenReturn(Optional.of(player));
		Player p = playerService.getPlayerById("aardsda01").getBody();
		assertEquals("check player by id","aardsda01",p.getPlayerID());
	}
	@Test
	void contextLoads() {
	}

}
