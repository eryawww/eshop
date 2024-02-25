package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
public interface ProductService {
    Product create(Product product);
    Product delete(String productId);
    public Product findById(String productId);
    public Product update(String productId, Product car);
    public List<Product> findAll();
}
