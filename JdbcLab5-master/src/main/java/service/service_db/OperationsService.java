package service.service_db;

import bl.Util;
import dao.OperationsDAO;
import entity.Product;
import entity.ProductInShop;
import entity.Shop;
import org.h2.jdbc.JdbcSQLNonTransientException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationsService extends Util implements OperationsDAO {


    public void addConsignment(Shop shop, Product product, Long count) {
        ProductService productService = new ProductService();
        ProductInShopService productInShopService = new ProductInShopService();

        ProductInShop productInShop = new ProductInShop();
        productInShop.setShopId(shop.getId());
        productInShop.setProductId(product.getId());
        productInShop.setCount(count);
        try {
            productService.add(product);
            productInShopService.add(productInShop);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Shop findCheapestShop(String titleProduct) {
        ProductService productService = new ProductService();
        ProductInShopService productInShopService = new ProductInShopService();
        ShopService shopService = new ShopService();
        Product product = new Product();
        ProductInShop productInShop = new ProductInShop();
        Shop shop = new Shop();
        try {
            product = productService.findCheapest(titleProduct);
            productInShop = productInShopService.getByProductId(product.getId());
            shop = shopService.getById(productInShop.getShopId());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return shop;
    }

    public void whatCanBy(Shop shop, Long money) {
        //ProductService productService = new ProductService();
        ShopService shopService = new ShopService();
        ProductInShopService productInShopService = new ProductInShopService();
        List<ProductInShop> productInShopList = new ArrayList<ProductInShop>();
        try {
            productInShopList = productInShopService.getByShopId(shop.getId());
            for(ProductInShop productInShop : productInShopList) {
                Long count = productInShop.getCount();
                ProductService productService = new ProductService();
                Product product = productService.getById(productInShop.getProductId());
                Long price = product.getPrice();
                System.out.println("В " + shop.getTitle() + " можно купить " +  money/price + " " + product.getTitle());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Long buyConsignment(String shopTitle, String productTitle, Long count) {
        ShopService shopService = new ShopService();
        ProductInShopService productInShopService = new ProductInShopService();
        List<ProductInShop> productInShopsList = new ArrayList<ProductInShop>();
        Shop shop = new Shop();
        Product product = new Product();
        ProductInShop productInShop = new ProductInShop();
        Long check = -1L;
        try {
            shop = shopService.getByTitle(shopTitle);
            //product = productService.getByTitle(productTitle);
            productInShopsList = productInShopService.getByShopId(shop.getId());
            for (ProductInShop productInShop1: productInShopsList) {
                ProductService productService = new ProductService();
                product = productService.getById(productInShop1.getProductId());
                productInShop = productInShop1;
                if(product.getTitle().equals(productTitle)){
                    Long price = product.getPrice();
                    Long count_ = productInShop.getCount();
                    if(count_ < count){
                        System.out.println("not enough goods");
                    }else{
                        check = price*count;
                    }
                    break;
                }
            }
        }catch (JdbcSQLNonTransientException e){
            System.out.println("Shop or product not found");
        }catch (SQLException e){
            System.out.println("Shop or product not found");
        }

        return check;

    }

    public Shop findCheapestShop(String productTitle, Long count) {
        Shop shop = findCheapestShop(productTitle);
        return shop;
    }
}
