package com.example.marketapp.repositories;

import com.example.marketapp.models.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.user.id = :userId")
    List<Item> getAllItemsByOwnerId(@Param("userId")Long userId);
}
