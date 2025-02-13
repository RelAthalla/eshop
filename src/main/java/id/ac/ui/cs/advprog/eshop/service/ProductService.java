package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    public Product findById(String productID); // untuk mengambil produk berdasarkan ID
    public void update(Product product);      // untuk memperbarui data produk
    public void delete(String productID);

}
