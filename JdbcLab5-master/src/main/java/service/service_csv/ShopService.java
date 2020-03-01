package service.service_csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import dao.ShopDAO;
import entity.Shop;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ShopService implements ShopDAO {

    private String csv = "shops.csv";
    public void add(Shop shop) throws SQLException {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csv, true), ',', '\0');
            String [] shop_ = (shop.getId() + "," + shop.getTitle()).split(",");
            writer.writeNext(shop_);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Shop> getAll() throws SQLException {
        return null;
    }

    public Shop getById(Long id) throws SQLException {
        Shop shop = new Shop();
        try {
            CSVReader reader = new CSVReader(new FileReader(csv), ',', '\0', 0);
            List<String[]> allProducts = reader.readAll();
            for(int i = 0; i < allProducts.size(); i++) {
                String[] row = allProducts.get(i);
                if(Long.parseLong(row[0]) == id){
                   shop.setId(Long.parseLong(row[0]));
                   shop.setTitle(row[1]);
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return shop;
    }

    public Shop getByTitle(String title) throws SQLException {
        Shop shop = new Shop();
        try {
            CSVReader reader = new CSVReader(new FileReader(csv), ',', '\0', 0);
            List<String[]> allProducts = reader.readAll();
            for(int i = 0; i < allProducts.size(); i++) {
                String[] row = allProducts.get(i);
                if(row[1].equals(title)){
                    shop.setId(Long.parseLong(row[0]));
                    shop.setTitle(row[1]);
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return shop;
    }

    public void update(Shop shop) throws SQLException {

    }

    public void remove(Shop shop) throws SQLException {

    }
}
