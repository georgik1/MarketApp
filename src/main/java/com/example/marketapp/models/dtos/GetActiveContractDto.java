package com.example.marketapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class GetActiveContractDto {

    private Long sellerId;
    private String sellerUsername;
    private Long itemId;
    private BigDecimal price;
    private boolean active;
}

