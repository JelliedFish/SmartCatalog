package dao;

import entity.ProductInShop;

import java.sql.SQLException;
import java.util.List;

public interface ProductInShopDAO {

    //create
    void add(ProductInShop productInShop) throws SQLException;

    //read
    List<ProductInShop> getAll() throws SQLException;

    ProductInShop getByProductId(Long productId) throws SQLException;

    List<ProductInShop> getByShopId(Long shopId) throws SQLException;

    ProductInShop getByShopIdAndProductId(Long shopId, Long productId) throws SQLException;

    //update
    void update(ProductInShop productInShop) throws SQLException;

    //delete
    void removeByShopId(ProductInShop productInShop) throws SQLException;
    void removeByProductId(ProductInShop productInShop) throws SQLException;
}
