package com.example.kursach;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class controller_admin_window {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_user;

    @FXML
    private Button add_worker;

    @FXML
    private Button back_button;

    @FXML
    private TableColumn<Table_users, String> dilution_date_table1;

    @FXML
    private TableColumn<Table_users, String> dilution_date_table2;

    @FXML
    private TableColumn<Table_users, String> gender_table1;

    @FXML
    private TableColumn<Table_users, String> gender_table2;

    @FXML
    private TableColumn<Table_users, String> login_table1;

    @FXML
    private TableColumn<Table_users, String> login_table2;

    @FXML
    private TableColumn<Table_users, String> mail_table1;

    @FXML
    private TableColumn<Table_users, String> mail_table2;

    @FXML
    private TableColumn<Table_users, String> name_table1;

    @FXML
    private TableColumn<Table_users, String> name_table2;

    @FXML
    private TableColumn<Table_users, String> passport_date_table1;

    @FXML
    private TableColumn<Table_users, String> passport_date_table2;

    @FXML
    private TableColumn<Table_users, String> password_table1;

    @FXML
    private TableColumn<Table_users, String> password_table2;

    @FXML
    private TableColumn<Table_users, String> patronymic_table1;

    @FXML
    private TableColumn<Table_users, String> patronymic_table2;

    @FXML
    private TableColumn<Table_users, String> phone_table1;

    @FXML
    private TableColumn<Table_users, String> phone_table2;

    @FXML
    private Button remove_user;

    @FXML
    private Button remove_worker;

    @FXML
    private TableColumn<Table_users, String> surname_table1;

    @FXML
    private TableColumn<Table_users, String> surname_table2;

    @FXML
    private AnchorPane main1;
    @FXML
    private TableView<Table_users> user_table;

    @FXML
    private TableView<Table_users> worker_table;

    @FXML
    void initialize() {
        addtable();


        remove_user.setOnAction(event -> {
            Const.rollers="client";

            FXMLLoader fxmlLoader = new FXMLLoader(Perehod.class.getResource("view_del_user.fxml"));

            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 300, 170);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Лаборатория здоровья");
            stage.show();

        });
        remove_worker.setOnAction(event -> {
            Const.rollers="worker";

            FXMLLoader fxmlLoader = new FXMLLoader(Perehod.class.getResource("view_del_user.fxml"));

            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 300, 170);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Лаборатория здоровья");
            stage.show();

        });
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();

            try {
                Perehod.TransitionWindows(main1,"view_authorization",300,400,false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        add_user.setOnAction(event -> {
            Const.rollers="client";
            FXMLLoader fxmlLoader = new FXMLLoader(Perehod.class.getResource("view_add_user.fxml"));

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
        add_worker.setOnAction(event -> {
            Const.rollers="worker";
            FXMLLoader fxmlLoader = new FXMLLoader(Perehod.class.getResource("view_add_user.fxml"));

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

        }
    private void addtable(){DatebaseHendler dbHandler = new DatebaseHendler();
        ObservableList<Table_users> tables1 = dbHandler.completeTable3("client");
        name_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("name"));
        surname_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("surname"));
        patronymic_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("patronymic"));
        gender_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("gender"));
        dilution_date_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("dilution_date"));
        login_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("login"));
        password_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("password"));
        passport_date_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("passport_date"));
        phone_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("phone"));
        mail_table1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("mail"));
        user_table.refresh();
        user_table.setItems(tables1);

        ObservableList<Table_users> tables2 = dbHandler.completeTable3("worker");
        name_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("name"));
        surname_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("surname"));
        patronymic_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("patronymic"));
        gender_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("gender"));
        dilution_date_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("dilution_date"));
        login_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("login"));
        password_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("password"));
        passport_date_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("passport_date"));
        phone_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("phone"));
        mail_table2.setCellValueFactory(new PropertyValueFactory<Table_users, String>("mail"));


        worker_table.refresh();
        worker_table.setItems(tables2);
    }

}
