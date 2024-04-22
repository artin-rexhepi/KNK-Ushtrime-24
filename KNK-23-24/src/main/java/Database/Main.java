package Database;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/knk2024";
//        String user = "root";
//        String password = "root1234";
//
//        Connection connection = DriverManager.getConnection(url, user, password);
//
//        if(connection.isValid(1000)){
//            System.out.println("Lidhja me baze te dhenave eshte krijuar me sukses!");
//        }
//
//        String sql = "SELECT * FROM USERS";
//        Statement statement = connection.createStatement();
//
//        ResultSet result = statement.executeQuery(sql);
//
//        while (result.next()){
//            int id = result.getInt("id");
//            String first_name = result.getString("first_name");
//            String last_name = result.getString("last_name");
//
//            System.out.println("ID: "+ id);
//            System.out.println("First name: "+ first_name);
//            System.out.println("Last name: "+ last_name);
//
//        }


            lexoPerdoruesin("1");


        }
    public static void lexoPerdoruesin (String id) throws SQLException {
        String sql = "SELECT * FROM USERS WHERE id = ?";
        Connection connection = DatabaseUtil.getConnection();
//        Statement statement = connection.createStatement();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int rid = result.getInt("id");
//            String first_name = result.getString("first_name");
//            String last_name = result.getString("last_name");

            User user = User.getInstancefromResultSet(result);
            user.printoDetajet();



        }
    }

}

class User {
    private int id;
    private String first_name;
    private String last_name;

    private User (int id, String first_name, String last_name){
        this.id=id;
        this.first_name=first_name;
        this.last_name =last_name;
    }

    public static User getInstancefromResultSet(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            return new User(id, first_name, last_name);
        } catch (Exception e) {
            return null;
        }
    }

    public void printoDetajet(){
        System.out.println("ID: "+this.id);
        System.out.println("First Name: "+ this.first_name);
        System.out.println("Last Name: " + this.last_name);
    }
}

