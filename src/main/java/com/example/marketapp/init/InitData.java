package com.example.marketapp.init;

import com.example.marketapp.services.Impl.ContractServiceImpl;
import com.example.marketapp.services.Impl.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        //used to quicktest data, decided to not delete this class

    }
}
