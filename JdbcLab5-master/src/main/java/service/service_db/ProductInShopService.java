package service.service_db;

import bl.Util;
import entity.Product;
import entity.ProductInShop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductInShopService extends Util implements dao.ProductInShopDAO {

    Connection connection = getConnection();

    public void add(ProductInShop productInShop) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO PRODUCT_IN_SHOP (SHOP_ID, PRODUCT_ID, COUNT) VALUES(?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, productInShop.getShopId());
            preparedStatement.setLong(2, productInShop.getProductId());
            preparedStatement.setLong(3, productInShop.getCount());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    public List<ProductInShop> getAll() throws SQLException {
        List<ProductInShop> productInShopList = new ArrayList<ProductInShop>();

        String sql = "SELECT SHOP_ID, PRODUCT_ID, 'COUNT' FROM PRODUCT_IN_SHOP";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                ProductInShop productInShop = new ProductInShop();

                productInShop.setShopId(resultSet.getLong("SHOP_ID"));
                productInShop.setProductId(resultSet.getLong("PRODUCT_ID"));
                productInShop.setCount(resultSet.getLong("COUNT"));
                productInShopList.add(productInShop);
            }


        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return productInShopList;
    }

    public ProductInShop getByProductId(Long productId) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT SHOP_ID, PRODUCT_ID, COUNT FROM PRODUCT_IN_SHOP WHERE PRODUCT_ID = ?";

        ProductInShop productInShop = new ProductInShop();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            productInShop.setShopId(resultSet.getLong("SHOP_ID"));
            productInShop.setProductId(resultSet.getLong("PRODUCT_ID"));
            productInShop.setCount(resultSet.getLong("COUNT"));

            preparedStatement.executeQuery();


        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return productInShop;
    }

    public List<ProductInShop> getByShopId(Long shopId) throws SQLException {
        List<ProductInShop> productInShopList = new ArrayList<ProductInShop>();

        String sql = "SELECT SHOP_ID, PRODUCT_ID, COUNT FROM PRODUCT_IN_SHOP WHERE SHOP_ID = ?";

        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, shopId );

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ProductInShop productInShop = new ProductInShop();

                productInShop.setShopId(resultSet.getLong("SHOP_ID"));
                productInShop.setProductId(resultSet.getLong("PRODUCT_ID"));
                productInShop.setCount(resultSet.getLong("COUNT"));
                productInShopList.add(productInShop);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            //TODO
        }
        finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return productInShopList;
    }

    public ProductInShop getByShopIdAndProductId(Long shopId, Long productId) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT SHOP_ID, PRODUCT_ID, COUNT FROM PRODUCT_IN_SHOP WHERE SHOP_ID = ? AND PRODUCT_ID = ?";

        ProductInShop productInShop = new ProductInShop();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, shopId);
            preparedStatement.setLong(2, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            productInShop.setShopId(resultSet.getLong("SHOP_ID"));
            productInShop.setProductId(resultSet.getLong("PRODUCT_ID"));
            productInShop.setCount(resultSet.getLong("COUNT"));

            preparedStatement.executeQuery();


        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return productInShop;
    }

    public void update(ProductInShop productInShop) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE PRODUCT_IN_SHOP SET SHOP_ID = ?, PRODUCT_ID = ?, 'COUNT' WHERE ID = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, productInShop.getShopId());
            preparedStatement.setLong(2, productInShop.getProductId());
            preparedStatement.setLong(3, productInShop.getCount());

            preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    public void removeByProductId(ProductInShop productInShop) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM PRODUCT_IN_SHOP WHERE PRODUCT_ID = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, productInShop.getProductId());

            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    public void removeByShopId(ProductInShop productInShop) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM PRODUCT_IN_SHOP WHERE SHOP_ID = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, productInShop.getProductId());

            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
