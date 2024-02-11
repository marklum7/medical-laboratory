package com.example.kursach;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class controller_worker_window {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private Hyperlink change_button;

    @FXML
    private TableColumn<Table_analysis, String> data_table1;

    @FXML
    private TableColumn<Table_analysis, String> data_table2;
    @FXML
    private TableView<Table_analysis> table1;

    @FXML
    private TableView<Table_analysis> table2;

    @FXML
    private TableView<Table_analysis> table3;


    @FXML
    private TableColumn<Table_analysis, String> data_table3;

    @FXML
    private Label dilution_date;

    @FXML
    private Label login;

    @FXML
    private Label name;

    @FXML
    private TableColumn<Table_analysis, String> name_table1;

    @FXML
    private TableColumn<Table_analysis, String> name_table2;

    @FXML
    private AnchorPane main1;

    @FXML
    private TableColumn<Table_analysis, String> name_table3;

    @FXML
    private TableColumn<Table_analysis, String> names_table1;

    @FXML
    private TableColumn<Table_analysis, String> names_table2;

    @FXML
    private TableColumn<Table_analysis, String> names_table3;

    @FXML
    private TableColumn<Table_analysis, String> status_table1;

    @FXML
    private Label surname;

    @FXML
    private TableColumn<Table_analysis, String> surname_table1;

    @FXML
    private TableColumn<Table_analysis, String> surname_table2;

    @FXML
    private TableColumn<Table_analysis, String> surname_table3;

    @FXML
    private TableColumn<Table_analysis, String> type_table2;

    @FXML
    private TableColumn<Table_analysis, String> type_table3;
    void UpdateData2(){
        name.setText(User_info.name);
        surname.setText(User_info.surname);
        dilution_date.setText(User_info.dilution_date);
        login.setText(User_info.login);
    }

    @FXML
    void initialize() {
        DatebaseHendler dbHandler = new DatebaseHendler();
        ObservableList<Table_analysis> tables1 = dbHandler.completeTable1("");
        name_table1.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("name"));
        surname_table1.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("surname"));
        names_table1.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("name_analysis"));
        data_table1.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("data_analysis"));
        status_table1.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("status"));

        table1.setItems(tables1);


        ObservableList<Table_analysis> tables2 = dbHandler.completeTable1("-");
        name_table2.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("name"));
        surname_table2.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("surname"));
        names_table2.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("name_analysis"));
        type_table2.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("type_analysis"));
        data_table2.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("data_analysis"));


        table2.setItems(tables2);

        ObservableList<Table_analysis> tables3 = dbHandler.completeTable1("+");
        name_table3.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("name"));
        surname_table3.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("surname"));
        names_table3.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("name_analysis"));
        type_table3.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("type_analysis"));
        data_table3.setCellValueFactory(new PropertyValueFactory<Table_analysis, String>("data_analysis"));


        table3.setItems(tables3);

        Const.scene2 = this;
        change_button.setOnAction(event -> {

            Const.rollers="worker";
            FXMLLoader fxmlLoader = new FXMLLoader(Perehod.class.getResource("view_edit_user.fxml"));

            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 300, 400);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Лаборатория здоровья");
            stage.show();



        });
        name.setText(User_info.name);
        surname.setText(User_info.surname);
        dilution_date.setText(User_info.dilution_date);
        login.setText(User_info.login);
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();

            try {
                Perehod.TransitionWindows(main1,"view_authorization",300,400,false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
