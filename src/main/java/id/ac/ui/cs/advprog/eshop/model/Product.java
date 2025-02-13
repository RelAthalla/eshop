package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;



@Getter @Setter
public class Product {
    private String productID;
    private String productName;
    private int productQuantity;

    // Constructor default untuk memastikan productID selalu terisi
    public Product() {
        if (this.productID == null || this.productID.isEmpty()) {
            this.productID = UUID.randomUUID().toString(); // Mengisi dengan UUID
        }
    }
}

