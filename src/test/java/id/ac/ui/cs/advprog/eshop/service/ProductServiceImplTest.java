package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    // Positive Test: Successfully editing a product
    @Test
    void testUpdateProduct_Success() {
        // Arrange
        Product updatedProduct = new Product();
        updatedProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
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

    // Negative Test: Editing a non-existent product (simulated as no operation)
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
        // Ensure the repository is told to update, but no validation on changes made since it doesn't exist.
    }

    // Positive Test: Successfully deleting a product
    @Test
    void testDeleteProduct_Success() {
        // Act
        productService.delete(existingProduct.getProductId());

        // Assert
        verify(productRepository, times(1)).delete(existingProduct.getProductId());
    }

    // Negative Test: Attempting to delete a non-existent product
    @Test
    void testDeleteProduct_Failure_NonExistentProduct() {
        String nonExistentProductId = "non-existent-id";

        // Act
        productService.delete(nonExistentProductId);

        // Assert
        verify(productRepository, times(1)).delete(nonExistentProductId);
        // This only confirms the call was made, as no exception is thrown in the repository for non-existing IDs.
    }
}