package com.example.FullFledgedInventoryPart.service;

import com.example.FullFledgedInventoryPart.entities.ProductInventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {

    ProductInventory create(ProductInventory productInventory);

    List<ProductInventory> getAll();

    ProductInventory update(Long porductId, ProductInventory productInventory);

    Optional<ProductInventory> getById(Long id);
}
