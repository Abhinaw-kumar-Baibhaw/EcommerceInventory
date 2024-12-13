package com.example.FullFledgedInventoryPart.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Inventory")
public class ProductInventory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    ProductInventory(){

    }

    public ProductInventory(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductInventory{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
