package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("Product A");
        product.setProductName("Barang");
        product.setProductQuantity(69);

        Mockito.when(productRepository.create(product)).thenReturn(product);
        productService.create(product);

        Mockito.when(productRepository.getProductByProductId("Product A")).thenReturn(product);
        Product savedProduct = productService.getProductByProductId("Product A");
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }


    @Test
    void testEditProduct(){
        Product product = new Product();
        product.setProductId("Product A");
        product.setProductName("Sampo");
        product.setProductQuantity(50);

        Mockito.when(productRepository.create(product)).thenReturn(product);
        productService.create(product);

        Mockito.when(productRepository.edit(product)).thenReturn(product);
        Product resultEdit = productService.edit(product);

        assertEquals("Product A", resultEdit.getProductId());
        assertEquals("Sampo", resultEdit.getProductName());
        assertEquals(50, resultEdit.getProductQuantity());
    }

    @Test
    void testDeleteProduct(){
        Product product = new Product();
        product.setProductId("Product A");
        product.setProductName("Barang");
        product.setProductQuantity(21);

        Mockito.when(productRepository.create(product)).thenReturn(product);
        productService.create(product);

        Mockito.when(productRepository.deleteByProductId("Product A")).thenReturn(product);
        Product resultDeleteId = productService.deleteByProductId("Product A");

        Mockito.when(productRepository.create(product)).thenReturn(product);
        productService.create(product);

        Mockito.when(productRepository.delete(0)).thenReturn(product);
        Product resultDelete = productService.delete(0);

        assertEquals("Product A", resultDelete.getProductId());
        assertEquals("Barang", resultDelete.getProductName());
        assertEquals(21, resultDelete.getProductQuantity());
    }

    @Test
    void findAll(){
        Product product = new Product();
        product.setProductId("Product A");
        product.setProductName("Barang");
        product.setProductQuantity(21);

        List<Product> listProduct = new ArrayList<>();
        listProduct.add(product);

        Mockito.when(productRepository.create(product)).thenReturn(product);
        productService.create(product);

        Mockito.when(productRepository.findAll()).thenReturn(listProduct);
        List<Product> listProductFound = productService.findAll();

        assertEquals(1, listProductFound.size());

    }
}