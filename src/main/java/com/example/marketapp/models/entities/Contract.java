package com.example.marketapp.models.entities;

import com.example.marketapp.models.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "seller_id")
    private Long sellerId;

    @Column(name = "buyer_id")
    private Long buyerId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "price")
    private BigDecimal price;

    //if isActive - '1', else - '0'
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
