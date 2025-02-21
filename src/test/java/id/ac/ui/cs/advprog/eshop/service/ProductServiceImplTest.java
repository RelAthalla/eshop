package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product existingProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        existingProduct = new Product();
        existingProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        existingProduct.setProductName("Sampo Cap Bambang");
        existingProduct.setProductQuantity(100);
    }

    // Test: Successfully creating a product
    @Test
    void testCreateProduct_Success() {
        // Act
        Product result = productService.create(existingProduct);

        // Assert
        assertEquals(existingProduct, result);
        verify(productRepository, times(1)).create(existingProduct);
    }

    // Test: Successfully retrieving all products
    @Test
    void testFindAll_Success() {
        // Arrange
        Product product2 = new Product();
        product2.setProductId("product-2");
        product2.setProductName("Sabun Wangi");
        product2.setProductQuantity(50);

        List<Product> mockProductList = Arrays.asList(existingProduct, product2);
        Iterator<Product> mockIterator = mockProductList.iterator();

        when(productRepository.findAll()).thenReturn(mockIterator);

        // Act
        List<Product> result = productService.findAll();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Sampo Cap Bambang", result.get(0).getProductName());
        assertEquals("Sabun Wangi", result.get(1).getProductName());
        verify(productRepository, times(1)).findAll();
    }

    // Test: Successfully retrieving a product by ID
    @Test
    void testFindById_Success() {
        // Arrange
        when(productRepository.findById(existingProduct.getProductId())).thenReturn(existingProduct);

        // Act
        Product result = productService.findById(existingProduct.getProductId());

        // Assert
        assertNotNull(result);
        assertEquals(existingProduct.getProductId(), result.getProductId());
        verify(productRepository, times(1)).findById(existingProduct.getProductId());
    }

    // Test: Retrieving a non-existent product by ID
    @Test
    void testFindById_Failure_NonExistentProduct() {
        // Arrange
        String nonExistentProductId = "non-existent-id";
        when(productRepository.findById(nonExistentProductId)).thenReturn(null);

        // Act
        Product result = productService.findById(nonExistentProductId);

        // Assert
        assertNull(result);
        verify(productRepository, times(1)).findById(nonExistentProductId);
    }

    // Test: Successfully updating a product
    @Test
    void testUpdateProduct_Success() {
        // Arrange
        Product updatedProduct = new Product();
        updatedProduct.setProductId(existingProduct.getProductId());
        updatedProduct.setProductName("Sampo Cap Updated");
        updatedProduct.setProductQuantity(200);

        doAnswer(invocation -> {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
            return null;
        }).when(productRepository).update(updatedProduct);

        // Act
        productService.update(updatedProduct);

        // Assert
        assertEquals("Sampo Cap Updated", existingProduct.getProductName());
        assertEquals(200, existingProduct.getProductQuantity());
        verify(productRepository, times(1)).update(updatedProduct);
    }

    // Test: Attempting to update a non-existent product
    @Test
    void testUpdateProduct_Failure_NonExistentProduct() {
        Product nonExistentProduct = new Product();
        nonExistentProduct.setProductId("non-existent-id");
        nonExistentProduct.setProductName("Non-Existent Product");
        nonExistentProduct.setProductQuantity(0);

        doNothing().when(productRepository).update(nonExistentProduct);

        // Act
        productService.update(nonExistentProduct);

        // Assert
        verify(productRepository, times(1)).update(nonExistentProduct);
    }

    // Test: Successfully deleting a product
    @Test
    void testDeleteProduct_Success() {
        // Act
        productService.delete(existingProduct.getProductId());

        // Assert
        verify(productRepository, times(1)).delete(existingProduct.getProductId());
    }

    // Test: Attempting to delete a non-existent product
    @Test
    void testDeleteProduct_Failure_NonExistentProduct() {
        String nonExistentProductId = "non-existent-id";

        // Act
        productService.delete(nonExistentProductId);

        // Assert
        verify(productRepository, times(1)).delete(nonExistentProductId);
    }
}
