/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Accounts;

/**
 *
 * @author Asus
 */
public class AccountDAO extends DBContext {

    public Accounts getAccount(String username, String password) {
        try {
            String sql = "Select * from Accounts";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Accounts account = new Accounts();
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    account.setUserName(username);
                    account.setPassword(password);
                    return account;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
