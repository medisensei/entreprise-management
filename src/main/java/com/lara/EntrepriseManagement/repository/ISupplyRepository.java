package com.lara.EntrepriseManagement.repository;

import com.lara.EntrepriseManagement.models.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplyRepository extends JpaRepository<Supply,Long> {
}
