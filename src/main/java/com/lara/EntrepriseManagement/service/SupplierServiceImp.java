package com.lara.EntrepriseManagement.service;

import com.lara.EntrepriseManagement.dto.SupplierDTO;
import com.lara.EntrepriseManagement.exceptions.TMNotFoundException;
import com.lara.EntrepriseManagement.mappers.SupplierMapper;
import com.lara.EntrepriseManagement.models.Supplier;
import com.lara.EntrepriseManagement.repository.ISupplierRepository;
import com.lara.EntrepriseManagement.service.interfaces.ISupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.lara.EntrepriseManagement.utility.EntityUpdateUtils.updateFieldIfNotNullOrEmpty;

@Service
@RequiredArgsConstructor
public class SupplierServiceImp implements ISupplierService{

    private static final int MAX_PER_PAGE = 5;

    private final ISupplierRepository supplierRepository;

    private final SupplierMapper supplierMapper;

    @Override
    public SupplierDTO getById(Long id) {
        Optional<Supplier> supOpt = supplierRepository.findById(id);
        return supOpt
                .map(supplierMapper::toDto)
                .orElseThrow( () -> new TMNotFoundException("Supplier with Id: %s doesn't exist"));


    }

    @Override
    public List<SupplierDTO> getByPersonName(String name) {
        return supplierMapper.toDTOs(supplierRepository.findByPersonName(name));
    }

    @Override
    public List<SupplierDTO> getAll() {
        return supplierMapper.toDTOs(supplierRepository.findAll());
    }

    @Override
    public void add(SupplierDTO supplierDTO) {

        this.supplierRepository.saveAndFlush(supplierMapper.toEntity(supplierDTO));

    }

    @Override
    public void edit(SupplierDTO supplierDTO) {

       Supplier supplier = supplierRepository.findById(supplierMapper.toEntity(supplierDTO).getId()).get();
        updateFieldIfNotNullOrEmpty(supplierDTO.personDTO().name(), supplier.getPerson()::setName);
        updateFieldIfNotNullOrEmpty(supplierDTO.personDTO().cin(), supplier.getPerson()::setCin);
        updateFieldIfNotNullOrEmpty(supplierDTO.personDTO().rib(), supplier.getPerson()::setRib);
        updateFieldIfNotNullOrEmpty(supplierDTO.personDTO().address(), supplier.getPerson()::setAddress);
        updateFieldIfNotNullOrEmpty(supplierDTO.personDTO().email(), supplier.getPerson()::setEmail);
        updateFieldIfNotNullOrEmpty(supplierDTO.personDTO().phone(), supplier.getPerson()::setPhone);

        supplierRepository.saveAndFlush(supplier);

    }

    @Override
    public void delete(Long aLong) {

        supplierRepository.deleteById(aLong);

    }

    @Override
    public List<SupplierDTO> getByPage(int page) {
       Page<Supplier> pageSupplier = this.supplierRepository.findAll(PageRequest.of(page, MAX_PER_PAGE));
      return supplierMapper.toDTOs(pageSupplier.getContent());

    }

    @Override
    public List<SupplierDTO> lookup(String text) {
        throw new  UnsupportedOperationException("getById not implemented yet");
    }
}
