package com.example.marketapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateItemDto {

    private String itemName;
    private Long ownerId;
}
