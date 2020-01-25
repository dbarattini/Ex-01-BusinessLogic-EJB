package it.distributedsystems.model.dao;

import java.util.Set;

public interface ShoppingCart {

    public void addProduct(Product product);
    public Set<Product> getProducts();
    public int buy();
    public void setCustomer(Customer customer);
}
