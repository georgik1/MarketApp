package com.example.marketapp.services;

import com.example.marketapp.models.dtos.CreateItemDto;
import com.example.marketapp.models.dtos.GetItemDto;

import java.util.List;

public interface ItemsService {

    void createItem(CreateItemDto createItemDto);

    List<GetItemDto> getAllItems(Long id);
}
