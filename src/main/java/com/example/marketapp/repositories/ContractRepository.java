package com.example.marketapp.repositories;

import com.example.marketapp.models.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query("SELECT c FROM Contract c WHERE c.status = 1")
    List<Contract> getAllActiveContracts();


    @Transactional
    @Modifying
    @Query("UPDATE Contract c SET c.price = :price WHERE c.itemId = :itemId")
    int updateContractPrice(@Param("price") BigDecimal price, @Param("itemId") Long itemId);


    @Transactional
    @Modifying
    @Query("UPDATE Contract  c SET c.buyerId = :buyerId, c.status = 0 WHERE c.itemId = :itemId")
    int updateCloseContract(@Param("itemId") Long itemId, @Param("buyerId") Long buyerId);


    @Query("SELECT c FROM Contract c WHERE c.status = 0")
    List<Contract> getAllClosedContracts();


    //TODO: fix method name
    @Query("SELECT c FROM Contract c WHERE c.sellerId = :sellerId")
    List<Contract> getAllContactsBySelerId(@Param("sellerId") Long sellerId);
}
