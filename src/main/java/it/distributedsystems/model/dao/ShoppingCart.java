package it.distributedsystems.model.dao;

import java.util.List;

public interface ShoppingCart {

    public void addProduct(Product product);
    public List<Product> getProducts();
    public void buy();
    public void setCustomer(Customer customer);
}
