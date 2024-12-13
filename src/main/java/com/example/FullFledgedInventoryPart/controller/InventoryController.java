package com.example.FullFledgedInventoryPart.controller;

import com.example.FullFledgedInventoryPart.entities.ProductInventory;
import com.example.FullFledgedInventoryPart.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    public ProductInventory create(@RequestBody ProductInventory productInventory){
        return inventoryService.create(productInventory);
    }

    @GetMapping("/getAll")
    public List<ProductInventory> getAll(){
        return inventoryService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<ProductInventory> getById(@PathVariable Long id){
        return inventoryService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ProductInventory update(@PathVariable Long id,@RequestBody ProductInventory productInventory){
        return inventoryService.update(id,productInventory);
    }

}
