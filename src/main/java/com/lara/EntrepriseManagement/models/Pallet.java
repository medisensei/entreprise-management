package com.lara.EntrepriseManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PALLET")
public class Pallet {

    @Id
    @Column(name = "PALLET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PALLET_NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "PALLET_WEIGHT")
    private Double palletWeight;

    @Column(name = "PALLET_LOAD")
    private Double loadWeight;

    @Column(name = "PALLET_FOREIGN")
    private Long foreignQuantity;

    @Column(name = "PALLET_ORANGE")
    private Long orangeQuantity;

    @Column(name = "PALLET_BLUE")
    private Long blueQuantity;

    @Column(name = "PALLET_IMPORT")
    private Date importDate;

    @Column(name = "PALLET_EXPORT")
    private Date exportDate;

    @ManyToOne
    @JoinColumn(name = "SUPPLY_ID")
    private Supply supply;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;












}
