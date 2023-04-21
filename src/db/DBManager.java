package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DBManager {
    public static final String url = "jdbc:postgresql://localhost:5432/bitlab_javaee_db";
    public static final String user = "postgres";
    public static final String password = "root";
    public static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Successfully connected with DB!");
        } catch (Exception e) {
            System.out.println("Error with connection with DB!");
            e.printStackTrace();
        }
    }


    public static void addItem(Items item){

        try{

            PreparedStatement statement = connection.prepareStatement("" +

                    "INSERT INTO cars (id, name, price, ramsize, memory, description) " +

                    "VALUES (NULL, ?, ?, ?, ?, ?)"

            );

            statement.setString(1, item.getName());

            statement.setDouble(2, item.getPrice());

            statement.setInt(3, item.getRamSize());

            statement.setString(3, item.getMemory());

            statement.setString(3, item.getDescription());

            int rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addUser(Users user){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (fullname, email, password) " +

                    "VALUES (?, ?, ?)"
            );

            statement.setString(1, user.getFullName());

            statement.setString(2, user.getEmail());

            statement.setString(3, user.getPassword());

            int rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<Items> getAllItems(){

        ArrayList<Items> itemList = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Long id = resultSet.getLong("id");

                String name = resultSet.getString("name");

                double price = resultSet.getDouble("price");

                int ramSize = resultSet.getInt("ramsize");

                String memory = resultSet.getString("memory");

                String description = resultSet.getString("description");

                itemList.add(new Items(id, name, price, ramSize, memory, description));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return itemList;
    }


    public static ArrayList<Users> getAllUsers(){

        ArrayList<Users> userList = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Long id = resultSet.getLong("id");

                String fullName = resultSet.getString("fullname");

                String email = resultSet.getString("email");

                String password = resultSet.getString("password");

                userList.add(new Users(id, fullName, email, password));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return userList;
    }
}
