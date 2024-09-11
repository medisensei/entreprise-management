package com.lara.EntrepriseManagement.repository;

import com.lara.EntrepriseManagement.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier,Long> {


    List<Supplier> findByPersonName(String name);
}
