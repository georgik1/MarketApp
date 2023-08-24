package com.example.marketapp.services.Impl;

import com.example.marketapp.models.dtos.CreateItemDto;
import com.example.marketapp.models.dtos.GetItemDto;
import com.example.marketapp.models.entities.Item;
import com.example.marketapp.models.entities.User;
import com.example.marketapp.repositories.ItemRepository;
import com.example.marketapp.repositories.UserRepository;
import com.example.marketapp.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImp implements ItemsService {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;


    @Autowired
    public ItemServiceImp(ItemRepository itemRepository, UserRepository userRepository){
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createItem(CreateItemDto createItemDto) {

        User user =
                userRepository.findById(createItemDto.getOwnerId()).orElse(null);

        Item item = new Item();
        item.setName(createItemDto.getItemName());
        item.setUser(user);

        itemRepository.save(item);
    }

    @Override
    public List<GetItemDto> getAllItems(Long id) {
        return itemRepository.getAllItemsByOwnerId(id)
                .stream()
                .map(item -> {
                    GetItemDto getItemDto = new GetItemDto();
                    getItemDto.setId(item.getId());
                    getItemDto.setItemName(item.getName());
                    getItemDto.setOwnerId(item.getUser().getId());
                    getItemDto.setOwnerUsername(item.getUser().getUserName());
                    return getItemDto;
                })
                .collect(Collectors.toList());
    }
}
