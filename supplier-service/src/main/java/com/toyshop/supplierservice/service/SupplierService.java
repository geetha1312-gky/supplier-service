package com.toyshop.supplierservice.service;

import com.toyshop.supplierservice.model.Supplier;
import java.util.List;

public interface SupplierService {
	Supplier createSupplier(Supplier supplier);

	Supplier getSupplierById(Long id);

	List<Supplier> getAllSuppliers();

	Supplier updateSupplier(Long id, Supplier supplier);

	void deleteSupplier(Long id);
}
