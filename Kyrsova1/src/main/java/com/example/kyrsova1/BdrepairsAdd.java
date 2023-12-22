
package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import java.sql.SQLException;
    import javafx.scene.Parent;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextField;
    import com.example.kyrsova1.DatabaseHandler;

public class BdrepairsAdd {

    @FXML
    private Button Button_cancel2;
    @FXML
    private Button Button_add_Parts;
    @FXML
    public TextField Partsnametextfield;
    @FXML
    public TextField KolvoPartstextfield;
    @FXML
    public TextField MarkaPartsTextfield;
    @FXML
    public TextField YerasPartsTextfield;

    @FXML
    void initialize() {
        /// Кнопка возврата назад
        Button_cancel2.setOnAction(event -> {
            Button_cancel2.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Bdrepairs.fxml"));
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

        /// Кнопка добавления запчастей в бд
        Button_add_Parts.setOnAction(event -> {
            try {
                // Получаем значения из текстовых полей
                String partsName = Partsnametextfield.getText().trim();
                String kolvoParts = KolvoPartstextfield.getText().trim();
                String markaParts = MarkaPartsTextfield.getText().trim();
                String yerasParts = YerasPartsTextfield.getText().trim();
                // Создаем экземпляр класса для работы с базой данных
                DatabaseHandler dbHandler = new DatabaseHandler();
                // Вызываем метод для добавления деталей ремонта в базу данных
                dbHandler.signUpParts(partsName, kolvoParts, markaParts, yerasParts);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Button_add_Parts.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Bdrepairs.fxml"));
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
