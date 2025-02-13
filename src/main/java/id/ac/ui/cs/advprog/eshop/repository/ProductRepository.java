package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productID) {
        return productData.stream()
                .filter(product -> product.getProductId().equals(productID))
                .findFirst()
                .orElse(null);
    }

    public void update(Product updatedProduct) {
        productData.stream()
                .filter(product -> product.getProductId().equals(updatedProduct.getProductId()))
                .findFirst()
                .ifPresent(product -> {
                    product.setProductName(updatedProduct.getProductName());
                    product.setProductQuantity(updatedProduct.getProductQuantity());
                });
    }

    public void delete(String productID) {
        productData.removeIf(product -> product.getProductId().equals(productID));
    }

}
