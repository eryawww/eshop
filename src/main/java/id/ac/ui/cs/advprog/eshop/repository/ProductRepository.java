package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    public Product create(Product product){
        productData.add(product);
        product.setProductId(String.valueOf(productData.size()));
        return product;
    }
    public void delete(int index){
        productData.remove(index);
    }
    public void delete(Product product) {
        productData.remove(product);
    }

    public void deleteByProductId(String productId){
        List<Product> allProducts = getAllProduct();
        for(Product currentProduct: allProducts) {
            if(currentProduct.getProductId().equals(productId)) {
                delete(currentProduct);
            }
        }
    }

    public Product edit(Product product){
        for (Product currentProduct: productData) {
            if (currentProduct.getProductId().equals(product.getProductId())) {
                currentProduct.setProductQuantity(product.getProductQuantity());
                currentProduct.setProductName(product.getProductName());
                return currentProduct;
            }
        }
        //  Harus dijamin product ditemukan
        return null;
    }

    public Product getProductByProductId(String productId){
        List<Product> allProduct = getAllProduct();
        for (Product currentProduct : allProduct) {
            if (currentProduct.getProductId().equals(productId)) {
                return currentProduct;
            }
        }
        // productId harus dijamin ditemukan
        return null;
    }

    public List<Product> getAllProduct(){
        Iterator<Product> productIterator = findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }
}
