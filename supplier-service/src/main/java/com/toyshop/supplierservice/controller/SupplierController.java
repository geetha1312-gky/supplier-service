package com.toyshop.supplierservice.controller;

import com.toyshop.supplierservice.model.Supplier;
import com.toyshop.supplierservice.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "*")
public class SupplierController {
	private final SupplierService supplierService;

	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		return supplierService.createSupplier(supplier);
	}

	@GetMapping("/{id}")
	public Supplier getSupplierById(@PathVariable Long id) {
		return supplierService.getSupplierById(id);
	}

	@GetMapping
	public List<Supplier> getAllSuppliers() {
		return supplierService.getAllSuppliers();
	}

	@PutMapping("/{id}")
	public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
		return supplierService.updateSupplier(id, supplier);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
		supplierService.deleteSupplier(id);
		return ResponseEntity.ok("Supplier deleted successfully");
	}
}
