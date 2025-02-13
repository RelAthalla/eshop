package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;



@Getter @Setter
public class Product {
    private String productId;
    private String productName;
    private int productQuantity;

    // Constructor default untuk memastikan productID selalu terisi
    public Product() {
        if (this.productId == null || this.productId.isEmpty()) {
            this.productId = UUID.randomUUID().toString(); // Mengisi dengan UUID
        }
    }
}

