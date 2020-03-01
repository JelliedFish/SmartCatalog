package service.service_db;

import bl.Util;
import dao.ShopDAO;
import entity.Shop;
import org.h2.jdbc.JdbcSQLNonTransientException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopService extends Util implements ShopDAO {

    Connection connection = getConnection();

    public void add(Shop shop) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SHOPS (ID, TITLE) VALUES(?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, shop.getId());
            preparedStatement.setString(2, shop.getTitle());

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

    public List<Shop> getAll() throws SQLException {
        List<Shop> shopList = new ArrayList<Shop>();

        String sql = "SELECT ID, TITLE FROM SHOPS";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Shop shop = new Shop();

                shop.setId(resultSet.getLong("ID"));
                shop.setTitle(resultSet.getString("TITLE"));

                shopList.add(shop);
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

        return shopList;
    }

    public Shop getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE FROM SHOPS WHERE ID = ?";

        Shop shop = new Shop();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            shop.setId(resultSet.getLong("ID"));
            shop.setTitle(resultSet.getString("TITLE"));

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
        return shop;
    }

    public Shop getByTitle(String title) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE FROM SHOPS WHERE TITLE = ?";

        Shop shop = new Shop();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            shop.setId(resultSet.getLong("ID"));
            shop.setTitle(resultSet.getString("TITLE"));

            preparedStatement.executeQuery();


        }catch (JdbcSQLNonTransientException e){
            System.out.println("Shop or product not found");
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return shop;
    }

    public void update(Shop shop) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE SHOPS SET TITLE = ? WHERE ID = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, shop.getTitle());
            preparedStatement.setLong(2, shop.getId());

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

    public void remove(Shop shop) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM SHOPS WHERE ID = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, shop.getId());

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
