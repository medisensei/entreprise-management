package com.lara.EntrepriseManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SUPPLY")
public class Supply {


    @Id
    @Column(name = "SUPPLY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SUPPLY_NPALLET")
    private Long palletNumber;

    @Column(name = "SUPPLY_PRICE")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;











}
