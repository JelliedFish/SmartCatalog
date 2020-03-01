package service.service_db;

import bl.Util;
import dao.ProductDAO;
import entity.Product;
import entity.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends Util implements ProductDAO {

    Connection connection = getConnection();

    public void add(Product product) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO PRODUCT (ID, TITLE, PRICE) VALUES(?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setLong(3, product.getPrice());

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

    public List<Product> getAll() throws SQLException {
        List<Product> productList = new ArrayList<Product>();

        String sql = "SELECT ID, TITLE FROM PRODUCT";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Product product = new Product();

                product.setId(resultSet.getLong("ID"));
                product.setTitle(resultSet.getString("TITLE"));
                product.setPrice(resultSet.getLong("PRICE"));

                productList.add(product);
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

        return productList;
    }

    public Product getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE, PRICE FROM PRODUCT WHERE ID = ?";

        Product product = new Product();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            product.setId(resultSet.getLong("ID"));
            product.setTitle(resultSet.getString("TITLE"));
            product.setPrice(resultSet.getLong("PRICE"));

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
        return product;
    }

    public Product getByTitle(String title) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE, PRICE FROM PRODUCT WHERE TITLE = ?";

        Product product = new Product();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            product.setId(resultSet.getLong("ID"));
            product.setTitle(resultSet.getString("TITLE"));
            product.setPrice(resultSet.getLong("PRICE"));

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
        return product;
    }

    public void update(Product product) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE PRODUCT SET TITLE = ?, PRICE = ? WHERE ID = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setLong(3, product.getId());

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

    public void remove(Product product) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM PRODUCT WHERE ID = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, product.getId());

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

    public Product findCheapest(String title) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE, PRICE FROM PRODUCT WHERE TITLE = ? AND PRICE = (SELECT MIN(PRICE) FROM PRODUCT)";

        Product product = new Product();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);


            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            product.setId(resultSet.getLong("ID"));
            product.setTitle(resultSet.getString("TITLE"));
            product.setPrice(resultSet.getLong("PRICE"));

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
        return product;
    }
}
