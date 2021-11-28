package com.example.marketapp.controllers;

import com.example.marketapp.models.dtos.CreateItemDto;
import com.example.marketapp.models.dtos.GetItemDto;
import com.example.marketapp.services.Impl.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemServiceImp itemServiceImp;

    @PostMapping("create")
    public void createItem(@RequestBody CreateItemDto createItemDto){
        itemServiceImp.createItem(createItemDto);
    }

    @GetMapping("get-all/{id}")
    public List<GetItemDto> getAllItems(@PathVariable("id") Long id){
       return itemServiceImp.getAllItems(id);

    }

}
