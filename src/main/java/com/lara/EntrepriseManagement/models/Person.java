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
@Table(name = "PERSON")
public class Person {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PERSON_NAME")
    private String name;

    @Column(name = "PERSON_ADDRESS")
    private String address;

    @Column(name = "PERSON_EMAIL")
    private String email;

    @Column(name = "PERSON_PHONE")
    private String phone;

    @Column(name = "PERSON_CIN")
    private String cin;

    @Column(name = "PERSON_RIB")
    private String rib;







}
