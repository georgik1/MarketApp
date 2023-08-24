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

    private final ContractServiceImpl contractServiceImpl;

    @Autowired
    public ContractController(ContractServiceImpl contractServiceImpl) {
        this.contractServiceImpl = contractServiceImpl;
    }

    @PostMapping("create")
    public void createContract(@RequestBody UpdateContractDto updateContractDto) {
        contractServiceImpl.createContract(updateContractDto);
    }

    @PutMapping("update-price")
    public void updateContractPrice(@RequestBody UpdateContractDto updateContractDto) {
        contractServiceImpl.updateContractPrice(updateContractDto);
    }

    @GetMapping("get-active")
    public List<GetActiveContractDto> getActiveContracts() {
        return contractServiceImpl.getAllActiveContracts();
    }

    @PutMapping("close")
    public void closeContract(@RequestBody CloseContractDto closeContractDto) {
        contractServiceImpl.closeContract(closeContractDto));
    }

    @GetMapping("get-closed")
    public List<GetClosedContractDto> getClosedContracts() {
        return contractServiceImpl.getAllClosedContracts();
    }

    @GetMapping("get/{id}")
    public List<GetClosedContractDto> getContractsBySellerId(@PathVariable("id") Long sellerId) {
        return contractServiceImpl.getAllContractsBySellerId(sellerId);
    }
}
