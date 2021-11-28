package com.example.marketapp.init;

import com.example.marketapp.models.dtos.CreateItemDto;
import com.example.marketapp.services.Impl.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final ItemServiceImp itemServiceImp;

    @Autowired
    public InitData(ItemServiceImp itemServiceImp) {
        this.itemServiceImp = itemServiceImp;
    }


    @Override
    public void run(String... args) throws Exception {

        CreateItemDto createItemDto = new CreateItemDto();
        createItemDto.setItemName("kola");
        createItemDto.setOwnerId(1L);

        itemServiceImp.createItem(createItemDto);

    }
}
