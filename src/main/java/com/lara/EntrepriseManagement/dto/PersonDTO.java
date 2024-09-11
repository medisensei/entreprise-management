package com.lara.EntrepriseManagement.dto;

public record PersonDTO(
        Long id,
        String name,
        String address,
        String email,
        String phone,
        String cin,
        String rib) {}
