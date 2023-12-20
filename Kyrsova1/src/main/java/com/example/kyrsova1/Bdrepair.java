
package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.stage.Stage;
    import javafx.scene.Scene;
    import java.io.IOException;
    import javafx.scene.Parent;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;

public class Bdrepair {

    @FXML
    private Button Back_button;
    @FXML
    void  initialize(){

        Back_button.setOnAction(event ->{
            Back_button.getScene().getWindow().hide();
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
        }  );


    }

}
















//     public Stage backstage;
//    @FXML
//    public void Back_button() throws IOException {
//        FXMLLoader MainMenuLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
//        Scene MainMenuScene = new Scene(MainMenuLoader.load(), 867, 500);
//        backstage.setScene(MainMenuScene);
//
//
//
//    }


