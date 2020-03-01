package dao;

import entity.Shop;

import java.sql.SQLException;
import java.util.List;

public interface ShopDAO {

    //create
    void add(Shop shop) throws SQLException;

    //read
    List<Shop> getAll() throws SQLException;

    Shop getById(Long id) throws SQLException;

    Shop getByTitle(String title) throws SQLException;

    //update
    void update(Shop shop) throws SQLException;

    //delete
    void remove(Shop shop) throws SQLException;

}
