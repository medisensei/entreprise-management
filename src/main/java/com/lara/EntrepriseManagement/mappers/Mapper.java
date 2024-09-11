package com.lara.EntrepriseManagement.mappers;

import org.springframework.util.CollectionUtils;

import java.util.List;

public interface Mapper<E, DTO> {
    E toEntity(DTO dto);
    DTO toDto(E entity);

    default List<E> toEntities(List<DTO> dtos){
        if (CollectionUtils.isEmpty(dtos)) return List.of();
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    default List<DTO> toDTOs(List<E> entities) {
        if (CollectionUtils.isEmpty(entities)) return List.of();
        return entities.stream()
                .map(this::toDto)
                .toList();
    }








}
