package com.example.marketapp.services;

import com.example.marketapp.models.dtos.CloseContractDto;
import com.example.marketapp.models.dtos.GetActiveContractDto;
import com.example.marketapp.models.dtos.GetClosedContractDto;
import com.example.marketapp.models.dtos.UpdateContractDto;

import java.util.List;

public interface ContractService {

    void createContract(UpdateContractDto updateContractDto);

    boolean updateContractPrice(UpdateContractDto updateContractDto);

    List<GetActiveContractDto> getAllActiveContracts();

    boolean closeContract(CloseContractDto closeContractDto);

    List<GetClosedContractDto> getAllClosedContracts();

    List<GetClosedContractDto> getAllContractsBySellerId(Long sellerId);
}
