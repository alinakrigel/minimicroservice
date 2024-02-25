
package com.example.CRUDintuit.repository;

import com.example.CRUDintuit.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {
}
