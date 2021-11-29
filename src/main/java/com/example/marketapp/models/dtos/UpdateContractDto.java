package com.example.marketapp.models.dtos;

import java.math.BigDecimal;

public class UpdateContractDto {

    private Long itemId;
    private BigDecimal price;


    public UpdateContractDto() {
    }


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
