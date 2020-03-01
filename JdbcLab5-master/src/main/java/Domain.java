import dao.OperationsDAO;
import dao.ShopDAO;
import entity.Product;
import entity.Shop;
import service.service_db.OperationsService;
import service.service_db.ShopService;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class Domain {

    public static void main(String[] args) {

        ShopDAO shopDAO = null;
        OperationsDAO operationsDAO = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".property.txt"));
            String line = reader.readLine();
            String[] ini = line.split("=");
            if(ini[1].equals("db")){
                shopDAO = new service.service_db.ShopService();
                operationsDAO = new service.service_db.OperationsService();
            }
            if(ini[1].equals("csv")){
                shopDAO = new service.service_csv.ShopService();
                operationsDAO = new service.service_csv.OperationsService();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        Shop shop = new Shop();
        shop.setId(2L);
        shop.setTitle("Ашан");

        Product product = new Product();
        product.setId(2L);
        product.setTitle("Веселый молочник");
        product.setPrice(90L);

        try {
            shopDAO.add(shop);
        }catch (SQLException e){
            e.printStackTrace();
        }

        //operationsService.addConsignment(shop, product, 300L);
        //System.out.println(operationsService.findCheapestShop("Prostokvashino").toString());
        //operationsService.whatCanBy(shop, 100L);
        //System.out.println(operationsDAO.buyConsignment("Пятерочкa", "Простоквашинo", 15L));
        //operationsDAO.whatCanBy(shop, 100L);


        System.out.println(operationsDAO.findCheapestShop("Шоколад ‘Аленка’").toString());
    }
}
