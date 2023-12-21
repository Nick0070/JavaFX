
package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.stage.Stage;
    import javafx.scene.Scene;
    import java.io.IOException;
    import javafx.scene.Parent;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextField;

public class login {
    @FXML
    private Button loginbutton;
    @FXML
    private TextField logintextfield;
    @FXML
    private TextField passtextfield;
    @FXML
    void initialize() {

        loginbutton.setOnAction(event -> {
            String enteredLogin = logintextfield.getText().trim();
            String enteredPassword = passtextfield.getText().trim();

            if ("admin".equals(enteredLogin) && "admin".equals(enteredPassword)) {
                loginbutton.getScene().getWindow().hide();

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
            }
        });
    }
}
