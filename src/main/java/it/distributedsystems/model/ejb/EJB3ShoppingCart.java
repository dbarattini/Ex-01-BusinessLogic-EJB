package it.distributedsystems.model.ejb;

import it.distributedsystems.model.dao.*;

import javax.ejb.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateful
@Local(ShoppingCart.class)
public class EJB3ShoppingCart implements ShoppingCart {

    private Set<Product> products = new HashSet<Product>();
    private Customer customer;

    @EJB(lookup = "java:global/distributed-systems-demo/distributed-systems-demo.war/EJB3PurchaseDAO!it.distributedsystems.model.dao.PurchaseDAO")
    private PurchaseDAO purchaseDAO;

    public EJB3ShoppingCart(){}

    @Transactional
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public int buy() {
        Purchase purchase = new Purchase();
        purchase.setProducts(products);
        purchase.setCustomer(customer);
        int id = purchaseDAO.insertPurchase(purchase);
        return id;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
