
package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import javafx.scene.Parent;
    import java.sql.SQLException;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextField;
    import com.example.kyrsova1.DatabaseHandler;

public class Bdklient_add {

    @FXML
    public TextField NameField;
    @FXML
    public TextField markfield;
    @FXML
    public TextField numberfield;
    @FXML
    private Button Button_cancel;
    @FXML
    public TextField Surnamefield;
    @FXML
    public Button Button_add_klient;
    @FXML
    public TextField Patronomikfield;

    @FXML
    void initialize() {
        ///Кнопка возврата назад
        Button_cancel.setOnAction(event -> {
            Button_cancel.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Bdklient.fxml"));
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

        ///Кнопка добавления клиента в бд
        Button_add_klient.setOnAction(event -> {
            try {
                // Получаем значения из текстовых полей
                String firstName = NameField.getText().trim();
                String lastName = Surnamefield.getText().trim();
                String patronomik = Patronomikfield.getText().trim();
                String carName = markfield.getText().trim();
                String carNumber = numberfield.getText().trim();
                // Создаем экземпляр класса для работы с базой данных
                DatabaseHandler dbHandler = new DatabaseHandler();
                // Вызываем метод для регистрации пользователя в базе данных
                dbHandler.signUpUser(firstName, lastName, patronomik, carName, carNumber);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
                Button_add_klient.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Bdklient.fxml"));
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
    }
}


