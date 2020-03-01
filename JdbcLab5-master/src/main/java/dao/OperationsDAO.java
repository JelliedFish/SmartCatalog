package dao;

import entity.Product;
import entity.Shop;

public interface OperationsDAO {
    void addConsignment(Shop shop, Product product, Long count);

    Shop findCheapestShop(String titleProduct);

    void whatCanBy(Shop shop, Long money);

    Long buyConsignment(String shopTitle, String productTitle, Long count);

    Shop findCheapestShop(String product, Long count);

}
