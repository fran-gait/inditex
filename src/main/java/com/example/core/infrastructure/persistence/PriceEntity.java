package com.example.core.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "brand_id")
    private int brandId;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "price_list")
    private int priceList;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "priority")
    private int priority;
    @Column(name = "price")
    private float price;
    @Column(name = "curr")
    private String curr;

}
