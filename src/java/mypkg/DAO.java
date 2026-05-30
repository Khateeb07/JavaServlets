/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypkg;

import java.sql.*;
import java.io.*;
import java.util.Properties;

/**
 *
 * @author khateeb
 */
public class DAO {

    Connection con = null;

    public Connection toConnect() throws ClassNotFoundException, SQLException, IOException {
        Properties props = new Properties();
        try {
            props.load(DAO.class.getResourceAsStream("db.properties"));
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            Class.forName(props.getProperty("db.driver"));
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void toClose() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public ResultSet toFetch(PreparedStatement pstm) throws SQLException {
        return pstm.executeQuery();
    }
}
