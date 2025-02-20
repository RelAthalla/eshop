package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> findAll();
    Product findById(String productId); // untuk mengambil produk berdasarkan ID
    void update(Product product);      // untuk memperbarui data produk
    void delete(String productId);

}
