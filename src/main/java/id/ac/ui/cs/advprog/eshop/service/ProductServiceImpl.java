package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product){
        productRepository.create(product);
        return product;
    }

    public void edit(Product product){
        productRepository.edit(product);
    }

    public Product getProductByProductId(String productId){
        return productRepository.getProductByProductId(productId);
    }

    @Override
    public void delete(int index){
        productRepository.delete(index);
    }

    @Override
    public void deleteByProductId(String productId){
        productRepository.deleteByProductId(productId);
    }

    @Override
    public List<Product> findAll(){
        return productRepository.getAllProduct();
    }
}
