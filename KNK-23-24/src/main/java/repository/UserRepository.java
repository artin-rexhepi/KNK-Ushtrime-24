package repository;

import Database.DatabaseUtil;
import model.dto.CreateUserDto;
import service.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    public static boolean create(CreateUserDto userData){
        Connection conn = DBConnector.getConnection();
        String query = "INSERT INTO USER VALUE (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, userData.getFirstName());
            pst.setString(2, userData.getLastName());
            pst.setString(3, userData.getEmail());
            pst.setString(4, userData.getSalt());
            pst.setString(5, userData.getPasswordHash());
            boolean inserted = pst.execute();
            pst.close();
            conn.close();
            return inserted;

        } catch (SQLException e) {
            return false;
        }
    }
}
