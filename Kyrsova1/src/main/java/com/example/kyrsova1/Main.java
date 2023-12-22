
package com.example.kyrsova1;

    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import javafx.fxml.FXMLLoader;
    import javafx.application.Application;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 867, 500);

        primaryStage.setTitle("Автомастерская");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}



