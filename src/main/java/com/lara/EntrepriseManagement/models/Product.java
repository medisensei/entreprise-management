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
@Table(name = "PRODUCT")
public class Product {


    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "CREATED")
    private Date created;

    @Column(name = "UPDATED")
    private Date updated;

    @Column(name = "STATUS")
    private boolean status;






}
