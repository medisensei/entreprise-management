package com.lara.EntrepriseManagement.service;

import com.lara.EntrepriseManagement.dto.SupplierDTO;
import com.lara.EntrepriseManagement.exceptions.TMNotFoundException;
import com.lara.EntrepriseManagement.mappers.SupplierMapper;
import com.lara.EntrepriseManagement.models.Supplier;
import com.lara.EntrepriseManagement.repository.ISupplierRepository;
import com.lara.EntrepriseManagement.service.interfaces.ISupplierService;
import com.lara.EntrepriseManagement.utility.TextUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.lara.EntrepriseManagement.utility.EntityUpdateUtils.updateFieldIfNotNullOrEmpty;

@Service
@RequiredArgsConstructor
public class SupplierServiceImp implements ISupplierService {

    private static final int MAX_PER_PAGE = 5;

    private final ISupplierRepository supplierRepository;

    private final SupplierMapper supplierMapper;

    private final TextUtil textUtil;


    @Override
    public SupplierDTO getById(Long id) {
        String supplier = textUtil.getMessage("supplier");
        return supplierRepository.findById(id)
                .map(supplierMapper::toDto)
                .orElseThrow(() -> new TMNotFoundException(textUtil.getMessage("error.notfound", supplier, id)));

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
    public SupplierDTO add(SupplierDTO supplierDTO) {

        String supplier = textUtil.getMessage("supplier");

        //TODO validations..
        Supplier savedSupplier = supplierRepository.save(supplierMapper.toEntity(supplierDTO));
        return supplierMapper.toDto(savedSupplier);
    }

    @Override
    public SupplierDTO edit(SupplierDTO supplierDTO, Long id) {

        SupplierDTO supplierd = getById(id);

        //TODO validations..
        Supplier supplier = supplierMapper.toEntity(supplierDTO);
        supplier.setId(id);
        supplier.getPerson().setId(supplierd.getPersonDTO().getId());
        Supplier savedSupplier = supplierRepository.save(supplier);
        return supplierMapper.toDto(savedSupplier);

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
        throw new UnsupportedOperationException("getById not implemented yet");
    }
}
