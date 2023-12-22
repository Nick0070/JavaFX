package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import javafx.scene.Parent;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;

public class Bdklient_add {

    @FXML
    private Button Button_cancel;

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
    }
}
