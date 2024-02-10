package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    Product createProduct(String name, String id, int quantity){
        Product product = new Product();
        product.setProductId(id);
        product.setProductName(name);
        product.setProductQuantity(quantity);

        return product;
    }

//    @Test
//    void testCreateAndFind() {
//        Product product = new Product();
//        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
//        product.setProductName("Sampo Cap Bambang");
//        product.setProductQuantity(100);
//
//        Mockito.when(productRepository.create(product)).thenReturn(product);
//        productService.create(product);
//
//        Mockito.when(productRepository.findAll()).thenReturn(List.of(product).iterator());
//        Iterator<Product> productIterator = productService.findAll().iterator();
//
//        assertTrue(productIterator.hasNext());
//        Product savedProduct = productIterator.next();
//        assertEquals(product.getProductId(), savedProduct.getProductId());
//        assertEquals(product.getProductName(), savedProduct.getProductName());
//        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
//    }
}