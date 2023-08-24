package com.example.marketapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CloseContractDto {

    private Long itemId;
    private Long buyerId;
}
