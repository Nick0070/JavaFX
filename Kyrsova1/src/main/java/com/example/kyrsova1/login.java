
package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.stage.Stage;
    import javafx.scene.Scene;
    import java.sql.ResultSet;
    import javafx.scene.Parent;
    import java.io.IOException;
    import java.sql.SQLException;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;
    import javafx.scene.control.Control;
    import javafx.scene.control.TextField;

public class login {
    @FXML
    private Button loginbutton;
    @FXML
    private TextField logintextfield;
    @FXML
    private TextField passtextfield;
    private Control b;

    @FXML
    void initialize() {

        loginbutton.setOnAction(event -> {
            String enteredLogin = logintextfield.getText().trim();
            String enteredPassword = passtextfield.getText().trim();

            if (!enteredLogin.equals("") && !enteredPassword.equals("")){
                loginUser(enteredLogin,enteredPassword );
            }  else  System.out.println("Eror");
        });
    }

    private void loginUser(String enteredLogin, String enteredPassword) {

        DatabaseHandler dbhand = new DatabaseHandler();
        User user = new User();
        user.setLogin(enteredLogin);
        user.setPassword(enteredPassword);
        ResultSet result = dbhand.getUser(user);

        int counter = 0;
        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        if (counter>=1){
            System.out.println("зашёл");
            opennewscen("Main.fxml");
        }
    }

    public void opennewscen (String window){
        loginbutton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Main.fxml"));
        try{
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
