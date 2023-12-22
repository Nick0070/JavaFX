package com.example.kyrsova1;

    import java.sql.*;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    // Метод для удаления клиента по ID
    public void deleteClient(int clientId) {
        String deleteQuery = "DELETE FROM " + Const.CLIENT_TABLE + " WHERE " + Const.CLIENT_ID + "=?";
        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Метод для удаления клиента по ID
    public void deleteParts(int partsid) {
        String deleteQuery = "DELETE FROM " + Const.PARTS_TABLE + " WHERE " + Const.PARTS_ID + "=?";
        try (Connection connection = getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, partsid);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ///Запрос данных из бд, таблица клиент
    public ResultSet getClientData() {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.CLIENT_TABLE;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
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
            e.printStackTrace();
        }
        return resSet;
    }

    // Добавление в бд клиента
    public void signUpUser(String firstName, String lastName, String patronomik, String carName, String carNumber)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.CLIENT_TABLE + "(" +
                Const.CLIENT_NAME + ", " + Const.CLIENT_SEARNAME + ", " +
                Const.CLIENT_PATRONOMIK + ", " + Const.CLIENT_CARNAME + ", " +
                Const.CLIENT_CARNUMBER + ")" +
                "VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, firstName);
        prSt.setString(2, lastName);
        prSt.setString(3, patronomik);
        prSt.setString(4, carName);
        prSt.setString(5, carNumber);

        prSt.executeUpdate();
    }

    // Добавление в бд запчастей
    public void signUpParts(String partsName, String kolvoParts, String markaParts, String yerasParts)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.PARTS_TABLE + "(" +
                Const.PARTS_NAME + ", " + Const.PARTS_KOL + ", " +
                Const.PARTS_MARKA + ", " + Const.PARTS_YEAR + ")" +
                "VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, partsName);
        prSt.setString(2, kolvoParts);
        prSt.setString(3, markaParts);
        prSt.setString(4, yerasParts);

        prSt.executeUpdate();
    }

    ///Подключение к бд
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    ///Получение информации из таблицы пользователи
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
