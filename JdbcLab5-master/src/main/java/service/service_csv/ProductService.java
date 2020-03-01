package service.service_csv;

import au.com.bytecode.opencsv.CSVWriter;
import dao.ProductDAO;
import entity.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductService implements ProductDAO {
    private String csv = "products.csv";
    public void add(Product product) throws SQLException {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csv, true), ',', '\0');
            String [] shop_ = (product.getTitle()).split(",");
            writer.writeNext(shop_);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Product> getAll() throws SQLException {
        return null;
    }

    public Product getById(Long id) throws SQLException {
        return null;
    }

    public Product getByTitle(String title) throws SQLException {
        return null;
    }

    public void update(Product product) throws SQLException {

    }

    public void remove(Product product) throws SQLException {

    }

    public Product findCheapest(String title) throws SQLException {
        return null;
    }
}
