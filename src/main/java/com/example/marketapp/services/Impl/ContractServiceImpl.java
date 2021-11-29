package com.example.marketapp.services.Impl;

import com.example.marketapp.models.dtos.CloseContractDto;
import com.example.marketapp.models.dtos.GetActiveContractDto;
import com.example.marketapp.models.dtos.GetClosedContractDto;
import com.example.marketapp.models.dtos.UpdateContractDto;
import com.example.marketapp.models.entities.Contract;
import com.example.marketapp.models.entities.Item;
import com.example.marketapp.models.entities.User;
import com.example.marketapp.models.enums.Status;
import com.example.marketapp.repositories.ContractRepository;
import com.example.marketapp.repositories.ItemRepository;
import com.example.marketapp.repositories.UserRepository;
import com.example.marketapp.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void createContract(UpdateContractDto updateContractDto) {

        Item item =
                itemRepository.findById(updateContractDto.getItemId()).orElse(null);

        if (item != null) {
            Contract contract = new Contract();
            contract.setItemId(updateContractDto.getItemId());
            contract.setPrice(updateContractDto.getPrice());
            contract.setSellerId(item.getUser().getId());
            contract.setStatus(Status.ACTIVE);
            contractRepository.save(contract);
        }
    }

    @Override
    public boolean updateContractPrice(UpdateContractDto updateContractDto) {

        return contractRepository
                .updateContractPrice(updateContractDto.getPrice(), updateContractDto.getItemId()) > 0;
    }

    @Override
    public List<GetActiveContractDto> getAllActiveContracts() {

        return contractRepository.getAllActiveContracts().stream()
                .map(contract -> {
                    GetActiveContractDto dto = new GetActiveContractDto();
                    User seller = userRepository.getById(contract.getSellerId());
                    dto.setSellerId(contract.getSellerId());
                    dto.setSellerUsername(seller.getUserName());
                    dto.setItemId(contract.getItemId());
                    dto.setPrice(contract.getPrice());
                    dto.setActive(true);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean closeContract(CloseContractDto closeContractDto) {

        return contractRepository
                .updateCloseContract(closeContractDto.getItemId(), closeContractDto.getBuyerId()) > 0;
    }

    @Override
    public List<GetClosedContractDto> getAllClosedContracts() {

        return contractRepository.getAllClosedContracts().stream()
                .map(contract -> {
                    GetClosedContractDto dto = new GetClosedContractDto();
                    User seller = userRepository.getById(contract.getSellerId());
                    User buyer = userRepository.getById(contract.getBuyerId());
                    dto.setSellerId(contract.getSellerId());
                    dto.setSellerUsername(seller.getUserName());
                    dto.setBuyerId(contract.getBuyerId());
                    dto.setBuyerUsername(buyer.getUserName());
                    dto.setItemId(contract.getItemId());
                    dto.setPrice(contract.getPrice());
                    dto.setActive(false);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<GetClosedContractDto> getAllContractsBySellerId(Long sellerId) {

        return contractRepository.getAllContactsBySelerId(sellerId).stream()
                .map(contract -> {
                    GetClosedContractDto dto = new GetClosedContractDto();
                    User seller = userRepository.getById(contract.getSellerId());
                    dto.setSellerId(contract.getSellerId());
                    dto.setSellerUsername(seller.getUserName());
                    if(dto.getBuyerId() != null) {
                        User buyer = userRepository.getById(contract.getBuyerId());
                        dto.setBuyerId(contract.getBuyerId());
                        dto.setBuyerUsername(buyer.getUserName());
                    }

                    dto.setItemId(contract.getItemId());
                    dto.setPrice(contract.getPrice());
                    dto.setActive(false);
                    return dto;
                })
                .collect(Collectors.toList());
    }


}

