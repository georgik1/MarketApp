package com.example.marketapp.models.dtos;

public class CloseContractDto {

    private Long itemId;
    private Long buyerId;

    public CloseContractDto() {
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}
