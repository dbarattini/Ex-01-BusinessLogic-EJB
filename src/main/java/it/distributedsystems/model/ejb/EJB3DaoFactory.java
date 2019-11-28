package it.distributedsystems.model.ejb;

import java.util.Hashtable;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;

import it.distributedsystems.model.dao.*;
import org.apache.log4j.Logger;
import org.jboss.system.server.ServerInfo;

public class EJB3DaoFactory extends DAOFactory {
    private static Logger logger = Logger.getLogger("DAOFactory");

    @EJB private ProducerDAO producerDao;
    @EJB private ProductDAO productDao;
    @EJB private CustomerDAO customerDao;
    @EJB private PurchaseDAO purchaseDao;

    public EJB3DaoFactory() {


    }

    private static InitialContext getInitialContext() throws Exception {
        Hashtable props = getInitialContextProperties();
        return new InitialContext();
    }

    private static Hashtable getInitialContextProperties() {
        Hashtable props = new Hashtable();
        //props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        //props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        //props.put("java.naming.provider.url", "127.0.0.1:1099"); //(new ServerInfo()).getHostAddress()  --- 127.0.0.1 --
        props.put(Context.INITIAL_CONTEXT_FACTORY,  "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
        return props;
    }

    public CustomerDAO getCustomerDAO() {
        try {
            InitialContext context = getInitialContext();
            CustomerDAO result = (CustomerDAO)context.lookup("java:global/distributed-systems-demo/distributed-systems-demo.war/EJB3CustomerDAO!it.distributedsystems.model.dao.CustomerDAO");
            return result;
//            return customerDao;
        } catch (Exception var3) {
            logger.error("Error looking up EJB3CustomerDAO", var3);
            return null;
        }
    }

    public PurchaseDAO getPurchaseDAO() {
        try {
            InitialContext context = getInitialContext();
            PurchaseDAO result = (PurchaseDAO)context.lookup("java:global/distributed-systems-demo/distributed-systems-demo.war/EJB3PurchaseDAO!it.distributedsystems.model.dao.PurchaseDAO");
            return result;
//            return purchaseDao;
        } catch (Exception var3) {
            logger.error("Error looking up EJB3PurchaseDAO", var3);
            return null;
        }
    }

    public ProductDAO getProductDAO() {
        try {
            InitialContext context = getInitialContext();
            ProductDAO result = (ProductDAO)context.lookup("java:global/distributed-systems-demo/distributed-systems-demo.war/EJB3ProductDAO!it.distributedsystems.model.dao.ProductDAO");
            return result;
//            return productDao;
        } catch (Exception var3) {
            logger.error("Error looking up EJB3ProductDAO", var3);
            return null;
        }
    }

    public ProducerDAO getProducerDAO() {
        try {
            InitialContext context = getInitialContext();
            ProducerDAO result = (ProducerDAO)context.lookup("java:global/distributed-systems-demo/distributed-systems-demo.war/EJB3ProducerDAO!it.distributedsystems.model.dao.ProducerDAO");
            return result;
//            return producerDao;
        } catch (Exception var3) {
            logger.error("Error looking up EJB3ProducerDAO", var3);
            return null;
        }
    }
}
