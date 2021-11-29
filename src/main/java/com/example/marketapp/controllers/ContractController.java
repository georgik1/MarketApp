package com.example.marketapp.controllers;

import com.example.marketapp.models.dtos.CloseContractDto;
import com.example.marketapp.models.dtos.GetActiveContractDto;
import com.example.marketapp.models.dtos.GetClosedContractDto;
import com.example.marketapp.models.dtos.UpdateContractDto;
import com.example.marketapp.services.Impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
public class ContractController {

    @Autowired
    private ContractServiceImpl contractServiceImpl;

    @PostMapping("create")
    public void createContract(@RequestBody UpdateContractDto updateContractDto) {
        contractServiceImpl.createContract(updateContractDto);
    }

    @PutMapping("update-price")
    public ResponseEntity updateContractPrice(@RequestBody UpdateContractDto updateContractDto) {

        if (contractServiceImpl.updateContractPrice(updateContractDto)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-active")
    public List<GetActiveContractDto> getActiveContracts(){
        return contractServiceImpl.getAllActiveContracts();
    }

    @PutMapping("close")
    public ResponseEntity closeContract(@RequestBody CloseContractDto closeContractDto) {

        if (contractServiceImpl.closeContract(closeContractDto)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-closed")
    public List<GetClosedContractDto> getClosedContracts(){
        return contractServiceImpl.getAllClosedContracts();
    }

    @GetMapping("get/{id}")
    public List<GetClosedContractDto> getContractsBySellerId(@PathVariable("id") Long sellerId){
        return contractServiceImpl.getAllContractsBySellerId(sellerId);
    }
}
