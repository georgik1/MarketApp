package com.example.marketapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetItemDto {

    private Long id;
    private String itemName;
    private Long ownerId;
    private String ownerUsername;

}
