package com.example.FullFledgedInventoryPart.serviceImpl;

import com.example.FullFledgedInventoryPart.entities.ProductInventory;
import com.example.FullFledgedInventoryPart.repo.InventoryRepo;
import com.example.FullFledgedInventoryPart.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImplementation implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public ProductInventory create(ProductInventory productInventory) {
        return inventoryRepo.save(productInventory);
    }

    @Override
    public List<ProductInventory> getAll() {
        return inventoryRepo.findAll();
    }

    @Override
//    @KafkaListener(topics = "order-created", groupId = "inventory-service-group")
    public ProductInventory update(Long productId,ProductInventory productInventory) {
        Optional<ProductInventory> inventory = inventoryRepo.findById(productId);
        if(inventory.isPresent()){
            ProductInventory productInventory1 = inventory.get();
            productInventory1.setQuantity(productInventory.getQuantity());
            inventoryRepo.save(productInventory1);
//            System.out.println("Received Order Event from kafka");
        }
        return productInventory;
    }

    @Override
    public Optional<ProductInventory> getById(Long id) {
       return inventoryRepo.findById(id);
    }
}
