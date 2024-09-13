package com.lara.EntrepriseManagement.service.interfaces;

import com.lara.EntrepriseManagement.dto.SupplierDTO;

import java.util.List;

public interface ISupplierService {


    SupplierDTO getById(Long id);

    List<SupplierDTO> getByPersonName(String name);

    List<SupplierDTO> getAll();

    SupplierDTO add(SupplierDTO t);

    SupplierDTO edit(SupplierDTO t, Long id);

    void delete(Long l);

    List<SupplierDTO> getByPage(int page);

    List<SupplierDTO> lookup(String text);

}
