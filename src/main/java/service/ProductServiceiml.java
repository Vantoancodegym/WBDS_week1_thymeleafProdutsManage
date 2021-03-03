package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceiml implements ProductService{
    private static Map<Integer,Product> products=new HashMap<>();
    static {
        products.put(1, new Product(1,"iphone",1000,"beautiful"));
        products.put(2, new Product(2,"samsung",900,"beautiful"));
        products.put(3, new Product(3,"oppo",800,"beautiful"));
        products.put(4, new Product(4,"huawei",700,"beautiful"));
        products.put(5, new Product(5,"nokia",600,"beautiful"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.replace(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
