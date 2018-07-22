/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author <<
 */
public class Database {

    private Connection conn;
    private Statement statement;

    static String url = "jdbc:mysql://localhost/";
    static String dbName = "usersdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String driver = "com.mysql.jdbc.Driver";
    static String userName = "root";
    static String password = "1234";

    public static List<Customer> vericek(List<Customer> a) throws SQLException {

        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            Statement statement = (Statement) c.createStatement();
            String s = "SELECT * FROM usersinfo";

            ResultSet rs = statement.executeQuery(s);

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setSurname(rs.getString("surname"));
                customer.setMaas(rs.getInt("maas"));

                a.add(customer);
                customer = null;
            }
           
            rs.close();
        } catch (Exception e) {
           
            System.out.println(e);
        }
        return a;
    }

}
