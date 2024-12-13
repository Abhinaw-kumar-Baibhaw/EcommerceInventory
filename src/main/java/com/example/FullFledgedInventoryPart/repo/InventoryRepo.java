package com.example.FullFledgedInventoryPart.repo;

import com.example.FullFledgedInventoryPart.entities.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepo extends JpaRepository<ProductInventory,Long> {
}
