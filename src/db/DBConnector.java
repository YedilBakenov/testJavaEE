package db;

import model.City;
import model.Item;
import model.News;
import model.User;

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
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM items it " +
                    "INNER JOIN cities c ON it.city_id = c.id ORDER BY it.id DESC");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setPrice(resultSet.getDouble("price"));
                item.setDescription(resultSet.getString("description"));
                item.setModel(resultSet.getString("model"));

                City city = new City();
                city.setId(resultSet.getInt("city_id"));
                city.setName(resultSet.getString("name"));
                city.setCode(resultSet.getString("code"));

                item.setCity(city);

                items.add(item);
            }

            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public static ArrayList<City>getAllCities(){
        ArrayList<City> cities = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cities");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setCode(resultSet.getString("code"));
                city.setName(resultSet.getString("name"));

                cities.add(city);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return cities;

    }

    public static void addItem(Item item) {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO items " +
                    "(model, description, price, city_id) VALUES (?, ?, ?, ?)");

            statement.setString(1, item.getModel());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setInt(4, item.getCity().getId());

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
                    "description=?, price=?, city_id=? WHERE id=?");

            statement.setString(1, item.getModel());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setInt(4, item.getCity().getId());
            statement.setInt(5, item.getId());

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

    public static City getCityById(int cityId) {
        City city = new City();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cities WHERE id=?");
            statement.setInt(1, cityId);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                city.setId(resultSet.getInt("id"));
                city.setCode(resultSet.getString("code"));
                city.setName(resultSet.getString("name"));
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return city;
    }


    public static User getUserByEmail(String email){
        User user = new User();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<News> getAllNews() {

        ArrayList<News> newsList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM news n " +
                    "INNER JOIN users u " +
                    "ON n.user_id = u.id ORDER BY n.date DESC ");


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setContent(resultSet.getString("content"));
                news.setTitle(resultSet.getString("title"));
                news.setDate(resultSet.getTimestamp("date"));

                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));

                news.setUser(user);
                newsList.add(news);
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return newsList;
    }

    public static News getNewsById(int id) {
        News news = new News();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM news n " +
                    "INNER JOIN users u " +
                    "ON n.user_id = u.id " +
                    "WHERE n.id=?");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                news.setId(resultSet.getInt("id"));
                news.setDate(resultSet.getTimestamp("date"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));

                User user = new User();
                user.setFullName(resultSet.getString("full_name"));
                user.setId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));

                news.setUser(user);

                statement.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }

    public static User getUserById(int userId) {

        User user = new User();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));
                statement.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void addNews(News news) {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO news (title, content, date, user_id) " +
                    "VALUES (?, ?, NOW(), ?)");
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setInt(3, news.getUser().getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateNews(News news) {

        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE news SET content=?, " +
                    "title=?, date=NOW() WHERE id=?");
            statement.setString(1, news.getContent());
            statement.setString(2, news.getTitle());
            statement.setInt(3, news.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteNewsById(int id) {

        try {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM news WHERE id=?");
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
