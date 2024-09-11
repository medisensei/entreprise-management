package com.lara.EntrepriseManagement.controllers;

import com.lara.EntrepriseManagement.dto.SupplierDTO;
import com.lara.EntrepriseManagement.service.interfaces.ISupplierService;
import com.lara.EntrepriseManagement.utility.TextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SupplierController {

    private final ISupplierService supplierServiceI;

    private final TextUtil textUtil;

    public ResponseEntity<List<SupplierDTO>> allSuppliers() {
        List<SupplierDTO> suppliers = supplierServiceI.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(suppliers);
    }


    @PostMapping("/suppliers")
    public ResponseEntity<String> addSupplier(@RequestBody SupplierDTO supplierDTO) {

        supplierServiceI.add(supplierDTO);
        String supplier = textUtil.getMessage("supplier");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(textUtil.getMessage("http.created", supplier));
    }


}
