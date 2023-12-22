package com.example.kyrsova1;

    import java.sql.*;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    ///Запрос данных из бд, таблица клиент
    public ResultSet getClientData() {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.CLIENT_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error while getting client data: " + e.getMessage());
            e.printStackTrace();
        }
        return resSet;
    }

    ///Запрос данных из бд, таблица запчасти
    public ResultSet getPartsData() {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.PARTS_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error while getting client data: " + e.getMessage());
            e.printStackTrace();
        }
        return resSet;
    }


    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " + Const.USER_Pass + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
