package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = service.findById(productId); // mengambil produk berdasarkan Id
        if (product != null) {
            model.addAttribute("product", product);
            return "editProduct"; // mengarahkan ke halaman edit
        }
        // Jika produk tidak ditemukan, kembalikan ke daftar produk
        return "redirect:/product/list";
    }

    // Menambahkan endpoint untuk proses pengeditan
    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product) {
        service.update(product); // memperbarui data produk
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        service.delete(productId); // memanggil service untuk menghapus produk
        return "redirect:/product/list"; // kembali ke halaman daftar produk
    }

}
