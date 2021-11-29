package com.example.marketapp.init;

import com.example.marketapp.models.dtos.UpdateContractDto;
import com.example.marketapp.models.dtos.CreateItemDto;
import com.example.marketapp.services.Impl.ContractServiceImpl;
import com.example.marketapp.services.Impl.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InitData implements CommandLineRunner {

    private final ItemServiceImp itemServiceImp;
    private final ContractServiceImpl contractService;

    @Autowired
    public InitData(ItemServiceImp itemServiceImp, ContractServiceImpl contractService) {
        this.itemServiceImp = itemServiceImp;
        this.contractService = contractService;
    }


    @Override
    public void run(String... args) throws Exception {

        CreateItemDto createItemDto = new CreateItemDto();
        createItemDto.setItemName("kola");
        createItemDto.setOwnerId(1L);

        itemServiceImp.createItem(createItemDto);


        UpdateContractDto updateContractDto = new UpdateContractDto();
        updateContractDto.setItemId(2L);
        updateContractDto.setPrice(BigDecimal.valueOf(100));

        contractService.createContract(updateContractDto);
    }
}
