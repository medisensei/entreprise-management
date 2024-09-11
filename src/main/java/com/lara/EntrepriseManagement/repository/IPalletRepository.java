package com.lara.EntrepriseManagement.repository;

import com.lara.EntrepriseManagement.models.Pallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPalletRepository extends JpaRepository<Pallet, Long> {
}
