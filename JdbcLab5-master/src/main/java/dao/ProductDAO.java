package dao;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    //create
    void add(Product product) throws SQLException;

    //read
    List<Product> getAll() throws SQLException;

    Product getById(Long id) throws SQLException;

    Product getByTitle(String title) throws SQLException;

    //update
    void update(Product product) throws SQLException;

    //delete
    void remove(Product product) throws SQLException;

    //findCheapestProduct
    Product findCheapest(String title) throws SQLException;
}
