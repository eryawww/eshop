package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@org.springframework.stereotype.Repository
public class ProductRepository implements Repository<Product> {
    private List<Product> productData = new ArrayList<>();
    public Product create(Product product){
        productData.add(product);
        if (product.getProductId() == null){
            product.setProductId(String.valueOf(Math.random()*1000));
        }
        return product;
    }

    public Product delete(String productId){
        List<Product> allProducts = findAll();
        for(Product currentProduct: allProducts) {
            if(currentProduct.getProductId().equals(productId)) {
                productData.remove(currentProduct);
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

    @Override
    public Product findById(String id) {
        for (Product product: productData){
            if (product.getProductId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product update(String id, Product updated) {
        for (int i=0; i<productData.size(); i++){
            Product car = productData.get(i);
            if(car.getProductId().equals(id)){
                car.setProductName(updated.getProductName());
                car.setProductId(updated.getProductId());
                car.setProductQuantity(updated.getProductQuantity());
            }
        }
        return null;
    }

    public Iterator<Product> findAllIter(){
        return productData.iterator();
    }
}
