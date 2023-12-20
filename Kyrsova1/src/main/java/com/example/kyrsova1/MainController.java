
package com.example.kyrsova1;

    import javafx.fxml.FXML;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import javafx.scene.Parent;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button buttonKlient;
    @FXML
    private Button Bdrepair;

    @FXML
    void  initialize(){

        //Кнопка перехода на экран с бд клиенитов
        buttonKlient.setOnAction(event ->{
            buttonKlient.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("BdKlient.fxml"));
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
        /////////////////////////////////////////////////

        //Кнопка перехода на экран с бд запчастей
        Bdrepair.setOnAction(event ->{
            Bdrepair.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Bdrepairs.fxml"));
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
        /////////////////////////////////////////////////
    }
}























//  public Stage mainStage;

//    @FXML
//    public void openBD_Client() throws IOException {
//
//
//
//
//        FXMLLoader MainMenuLoader = new FXMLLoader(Main.class.getResource("BdKlient.fxml"));
//        Scene MainMenuScene = new Scene(MainMenuLoader.load(), 867, 500);
//        mainStage.setScene(MainMenuScene);
//
//
//    }
