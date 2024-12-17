package com.example.FullFledgedInventoryPart.serviceImpl;

import com.example.FullFledgedInventoryPart.entities.ProductInventory;
import com.example.FullFledgedInventoryPart.repo.InventoryRepo;
import com.example.FullFledgedInventoryPart.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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

    public static final Logger logger = LoggerFactory.getLogger(InventoryServiceImplementation.class);

    @KafkaListener(topics = "order-created", groupId = "inventory-service-group")
    public void message(String message){
        logger.info("You are in consumer part in inventory" + message);
    }

    @Override
    public ProductInventory update(Long productId,ProductInventory productInventory) {
        Optional<ProductInventory> inventory = inventoryRepo.findById(productId);
        if(inventory.isPresent()){
            ProductInventory productInventory1 = inventory.get();
            productInventory1.setQuantity(productInventory.getQuantity());
            inventoryRepo.save(productInventory1);
            System.out.println("Received Order Event from kafka");
        }
        return productInventory;
    }

    @Override
    public Optional<ProductInventory> getById(Long id) {
       return inventoryRepo.findById(id);
    }
}
