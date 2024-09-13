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
@Table(name = "SUPPLIER")
public class Supplier {


    @Id
    @Column(name = "SUPPLIER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SUPPLIER_SOURCE")
    private String source;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;





    // Static inner Builder class



}
