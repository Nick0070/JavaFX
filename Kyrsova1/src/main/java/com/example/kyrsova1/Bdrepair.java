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
    import javafx.scene.control.TableView;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.cell.PropertyValueFactory;

public class Bdrepair {

    @FXML
    private Button Back_button;

    @FXML
    private TableView<Repair> Bdreapair;

    @FXML
    private TableColumn<Repair, Integer> idZapchasti;

    @FXML
    private TableColumn<Repair, String> Name_zaphacti;

    @FXML
    private TableColumn<Repair, String> kolvo;

    @FXML
    private TableColumn<Repair, String> marka;

    @FXML
    private TableColumn<Repair, String> yersproizvod;

    @FXML
    void initialize() {
        Back_button.setOnAction(event -> {
            Back_button.getScene().getWindow().hide();
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
        });

        idZapchasti.setCellValueFactory(new PropertyValueFactory<>("idzaphasti"));
        Name_zaphacti.setCellValueFactory(new PropertyValueFactory<>("Name"));
        kolvo.setCellValueFactory(new PropertyValueFactory<>("Kolvo"));
        marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        yersproizvod.setCellValueFactory(new PropertyValueFactory<>("yearproizvod"));

        loadRepairData();
    }

    private void loadRepairData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resultSet = dbHandler.getPartsData();
        try {
            while (resultSet.next()) {
                Repair repair = new Repair();
                repair.setIdZapchasti(resultSet.getInt(Const.PARTS_ID));
                repair.setName(resultSet.getString(Const.PARTS_NAME));
                repair.setKolvo(resultSet.getString(Const.PARTS_KOL));
                repair.setMarka(resultSet.getString(Const.PARTS_MARKA));
                repair.setYearproizvod(resultSet.getString(Const.PARTS_YEAR));
                // Добавьте данные в TableView
                Bdreapair.getItems().add(repair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
