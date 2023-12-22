
package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.stage.Stage;
    import javafx.scene.Scene;
    import java.sql.ResultSet;
    import java.io.IOException;
    import javafx.scene.Parent;
    import java.sql.SQLException;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;
    import javafx.scene.control.TableView;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.cell.PropertyValueFactory;

public class Bdklient {

    @FXML
    private Button Back_button;
    @FXML
    private Button button_delet;
    @FXML
    private TableView<Client> TableKlient;
    @FXML
    private TableColumn<Client, Integer> idColumn;
    @FXML
    private TableColumn<Client, String> nameColumn;
    @FXML
    private TableColumn<Client, String> carnameColumn;
    @FXML
    private TableColumn<Client, String> searnameColumn;
    @FXML
    private TableColumn<Client, String> carnumberColumn;
    @FXML
    private TableColumn<Client, String> patronomikColumn;

    @FXML
    void initialize() {

        ///Кнопка возврата назад
        Back_button.setOnAction(event -> {
            Back_button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Main.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        searnameColumn.setCellValueFactory(new PropertyValueFactory<>("searname"));
        patronomikColumn.setCellValueFactory(new PropertyValueFactory<>("patronomik"));
        carnameColumn.setCellValueFactory(new PropertyValueFactory<>("carname"));
        carnumberColumn.setCellValueFactory(new PropertyValueFactory<>("carnumber"));
        loadClientData();

        ////Кнопка удаления из бд
        button_delet.setOnAction(event -> {
            Client selectedClient = TableKlient.getSelectionModel().getSelectedItem();
            if (selectedClient != null) { deleteClient(selectedClient); }
        });
    }

    ///Метод загрузки в таблицу данных
    private void loadClientData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resultSet = dbHandler.getClientData();
        try {
            while (resultSet.next()) {
                Client client = new Client();
                client.setIdClient(resultSet.getInt(Const.CLIENT_ID));
                client.setName(resultSet.getString(Const.CLIENT_NAME));
                client.setSearname(resultSet.getString(Const.CLIENT_SEARNAME));
                client.setPatronomik(resultSet.getString(Const.CLIENT_PATRONOMIK));
                client.setCarname(resultSet.getString(Const.CLIENT_CARNAME));
                client.setCarnumber(resultSet.getString(Const.CLIENT_CARNUMBER));
                TableKlient.getItems().add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ///Метод удаления из бд
    private void deleteClient(Client client) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.deleteClient(client.getIdClient());
        TableKlient.getItems().remove(client);
    }
}
