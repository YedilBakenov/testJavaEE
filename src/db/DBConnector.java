package db;

import model.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnector {

    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/G129";
    private static String username = "postgres";
    private static String password = "postgres";


    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Item> getAllItems() {

        ArrayList<Item> items = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items ORDER BY id ASC");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setPrice(resultSet.getDouble("price"));
                item.setDescription(resultSet.getString("description"));
                item.setModel(resultSet.getString("model"));
                items.add(item);
            }

            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public static void addItem(Item item) {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO items (model, description, price) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, item.getModel());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());

            statement.executeUpdate();
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Item getItemById(int id) {
        Item item = new Item();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id=?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                item.setId(resultSet.getInt("id"));
                item.setModel(resultSet.getString("model"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));

                statement.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    public static void updateItem(Item item) {

        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE items SET model =?, " +
                    "description=?, price=? WHERE id=?");

            statement.setString(1, item.getModel());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setInt(4, item.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteItemById(int id) {

        try {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id=?");
        statement.setInt(1, id);

        statement.executeUpdate();
        statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
