package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator <Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator <Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator <Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());

        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    public void testEditProduct() {
        Product product = new Product();
        product.setProductName("Product A");
        product.setProductQuantity(5);
        productRepository.create(product);
        // Edit Product
        Product updatedProduct = new Product();
        updatedProduct.setProductId(product.getProductId());
        updatedProduct.setProductName("Product New");
        updatedProduct.setProductQuantity(15);
        Product editedProduct = productRepository.edit(updatedProduct);
        // Assert Test
        assertNotNull(editedProduct);
        assertEquals("Product New", editedProduct.getProductName());
        assertEquals(15, editedProduct.getProductQuantity());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setProductName("Product A");
        product.setProductQuantity(5);

        productRepository.create(product);
        productRepository.delete(product);

        // Ensure the product is no longer in the repository
        List<Product> allProduct = productRepository.getAllProduct();
        assertEquals(allProduct.size(), 0);
    }

    @Test
    public void testDeleteProductNotExisting() {
        Product product = new Product();
        product.setProductName("Product A");
        product.setProductQuantity(5);

        Product notExistingProduct = new Product();
        notExistingProduct.setProductName("Product B");
        notExistingProduct.setProductQuantity(10);

        productRepository.create(product);
        productRepository.delete(notExistingProduct);

        // Ensure the product is no longer in the repository
        List<Product> allProduct = productRepository.getAllProduct();
        assertEquals(allProduct.size(), 1);
    }

}
