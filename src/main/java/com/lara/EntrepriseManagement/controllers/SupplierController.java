package com.lara.EntrepriseManagement.controllers;

import com.lara.EntrepriseManagement.dto.SupplierDTO;
import com.lara.EntrepriseManagement.service.interfaces.ISupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController {

    final ISupplierService supplierServiceI;


    public SupplierController(ISupplierService supplierServiceI) {
        this.supplierServiceI = supplierServiceI;
    }


    public ResponseEntity<List<SupplierDTO>> allSuppliers(){

        List<SupplierDTO> supplierList = this.supplierServiceI.getAll();

        return new ResponseEntity<List<SupplierDTO>>(supplierList, HttpStatus.OK);
    }








}
