package com.lara.EntrepriseManagement.controllers;

import com.lara.EntrepriseManagement.dto.SupplierDTO;
import com.lara.EntrepriseManagement.service.interfaces.ISupplierService;
import com.lara.EntrepriseManagement.utility.TextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SupplierController {

    private final ISupplierService supplierServiceI;

    private final TextUtil textUtil;

    @GetMapping("/suppliers")
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


    @PutMapping("/suppliers/{id}")
    public ResponseEntity<String> editSupplier(@RequestBody SupplierDTO supplierDTO,@PathVariable("id") Long id) {

        supplierServiceI.edit(supplierDTO,id);
        String namePrefix = textUtil.getMessage("supplier");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(textUtil.getMessage("http.updated", namePrefix));
    }













}
