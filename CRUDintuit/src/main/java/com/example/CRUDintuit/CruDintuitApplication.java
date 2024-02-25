/***
 THIS IS A SIMPLE REST API PROJECT WRITTEN IN JAVA WITH THE USAGE OF SPRINGBOOT FRAMEWORK
 I USED LOMBOK FOR REDUCING BOILERPLATE CODE AND JPA FOR DB ACCESS.
 IN THIS PROJECT H2 IN MEMORY DB IS USED
***/
/***
 To run the application, run this module. then open a web browser with this domain :http://localhost:9090/h2
 The server runs on port 9090, it can be configured in application properties file.
 To enter db make sure the JDBC URL is = jdbc:h2:mem:testdb.
 The used DB in this project is h2 in memory. Each time the server stops DB is deleted.
 In order to import all player data to DB, when server starts you need to make an API call
 with the next endpoint : POST api/players/createAll.
 In order to run tests on this project:
 go to src\test\java\com\example\CRUDintuit\CruDintuitApplicationTests.java
 and run this module separately
 ***/

package com.example.CRUDintuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruDintuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDintuitApplication.class, args);
	}

}
