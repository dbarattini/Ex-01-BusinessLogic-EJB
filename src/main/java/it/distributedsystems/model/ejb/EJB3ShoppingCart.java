package it.distributedsystems.model.ejb;

import it.distributedsystems.model.dao.Customer;
import it.distributedsystems.model.dao.Product;
import it.distributedsystems.model.dao.ShoppingCart;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateful
@Local(ShoppingCart.class)
public class EJB3ShoppingCart implements ShoppingCart {

    private List<Product> products = new ArrayList<>();
    private Customer customer;

    public EJB3ShoppingCart(){}

    @Transactional
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void buy() {
        // TODO
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
