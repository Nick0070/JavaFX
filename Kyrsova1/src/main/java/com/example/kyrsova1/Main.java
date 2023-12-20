
package com.example.kyrsova1;

    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import javafx.fxml.FXMLLoader;
    import javafx.application.Application;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 867, 500);

        primaryStage.setTitle("Автомастерская");
        primaryStage.setScene(scene);
        primaryStage.show();

        //прошлый метод перехода между окнами
//       ((MainController)(fxmlLoader.getController())).mainStage = primaryStage;
//       ((Bdklient)(fxmlLoader.getController())).backstage = primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}



