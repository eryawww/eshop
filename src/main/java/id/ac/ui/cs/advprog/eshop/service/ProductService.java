package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
public interface ProductService {
    public Product create(Product product);
    public Product delete(int index);
    public Product deleteByProductId(String productId);
    public Product getProductByProductId(String productId);
    public Product edit(Product product);
    public List<Product> findAll();
}
