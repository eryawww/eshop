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
        if (product.getProductId() == null){
            product.setProductId(String.valueOf(Math.random()*1000));
        }
        return product;
    }
    public Product delete(int index){
        Product product = productData.get(index);
        productData.remove(index);
        return product;
    }
    public Product deleteByProduct(Product product) {
        productData.remove(product);
        return product;
    }

    public Product deleteByProductId(String productId){
        List<Product> allProducts = findAll();
        for(Product currentProduct: allProducts) {
            if(currentProduct.getProductId().equals(productId)) {
                deleteByProduct(currentProduct);
                return currentProduct;
            }
        }
        return null;
    }

    public Product edit(Product product){
        for (Product currentProduct: productData) {
            if (currentProduct.getProductId().equals(product.getProductId())) {
                currentProduct.setProductQuantity(product.getProductQuantity());
                currentProduct.setProductName(product.getProductName());
                return product;
            }
        }
        //  Harus dijamin product ditemukan
        return null;
    }

    public Product getProductByProductId(String productId){
        List<Product> allProduct = findAll();
        System.out.println("XXXXX "+allProduct.size());
        for (Product currentProduct : allProduct) {
            if (currentProduct.getProductId().equals(productId)) {
                return currentProduct;
            }
        }
        // productId harus dijamin ditemukan
        return null;
    }

    public List<Product> findAll(){
        Iterator<Product> productIterator = findAllIter();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    public Iterator<Product> findAllIter(){
        return productData.iterator();
    }
}
