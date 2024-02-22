package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
public interface ProductService {
    Product create(Product product);
    Product delete(String productId);
    public Product getProductByProductId(String productId);
    public Product edit(Product product);
    public List<Product> findAll();
}
