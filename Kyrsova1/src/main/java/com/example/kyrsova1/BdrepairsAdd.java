package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import javafx.scene.Parent;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;

public class BdrepairsAdd {

    @FXML
    private Button Button_cancel2;
    @FXML
    void initialize() {

        ///Кнопка возврата назад
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
    }
}
