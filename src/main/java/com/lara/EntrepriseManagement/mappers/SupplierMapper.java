package com.lara.EntrepriseManagement.mappers;

import com.lara.EntrepriseManagement.dto.SupplierDTO;
import com.lara.EntrepriseManagement.models.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierMapper implements Mapper<Supplier, SupplierDTO> {


    private final PersonMapper personMapper;

    @Override
    public Supplier toEntity(SupplierDTO supplierdto) {
        if (supplierdto == null) return null;
        return Supplier.builder()
                .person(personMapper.toEntity(supplierdto.getPersonDTO()))
                .source(supplierdto.getSource())
                .id(supplierdto.getId())
                .build();

    }

    @Override
    public SupplierDTO toDto(Supplier supplier) {
        if (supplier == null) return null;
        return  SupplierDTO.builder()
                .id(supplier.getId())
                .source(supplier.getSource())
                .personDTO(personMapper.toDto(supplier.getPerson()))
                .build();


    }
}