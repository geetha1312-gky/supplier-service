package com.toyshop.supplierservice.service;
import com.toyshop.supplierservice.exception.ResourceNotFoundException;
import com.toyshop.supplierservice.model.Supplier;
import com.toyshop.supplierservice.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    public SupplierServiceImpl(SupplierRepository supplierRepository){ this.supplierRepository=supplierRepository; }
    @Override public Supplier createSupplier(Supplier supplier){ return supplierRepository.save(supplier); }
    @Override public Supplier getSupplierById(Long id){ return supplierRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Supplier not found with ID: " + id)); }
    @Override public List<Supplier> getAllSuppliers(){ return supplierRepository.findAll(); }
    @Override public Supplier updateSupplier(Long id, Supplier supplier){ Supplier existing=getSupplierById(id); existing.setName(supplier.getName()); existing.setEmail(supplier.getEmail()); existing.setPhone(supplier.getPhone()); existing.setAddress(supplier.getAddress()); return supplierRepository.save(existing); }
    @Override public void deleteSupplier(Long id){ Supplier existing=getSupplierById(id); supplierRepository.delete(existing); }
}
