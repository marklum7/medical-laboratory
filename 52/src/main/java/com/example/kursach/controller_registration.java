package com.example.kursach;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class controller_registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink entry_button;

    @FXML
    private DatePicker dilution_date_field;

    @FXML
    private ComboBox<String> gender_field;

    @FXML
    private TextField login_field;

    @FXML
    private TextField mail_field;

    @FXML
    private TextField patronymic_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField passport_date_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField phone_field;
    @FXML
    private AnchorPane main1;

    @FXML
    private Button registration_button;

    @FXML
    private TextField surname_field;

    @FXML
    void initialize() {

        registration_button.setOnAction(event ->{
            
            singUpNewUser();

            registration_button.getScene().getWindow().hide();

            try {
                Perehod.TransitionWindows(main1,"view_authorization",300,400,false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        gender_field.getItems().addAll("Мужской","Женский");


        entry_button.setOnAction(event -> {
            entry_button.getScene().getWindow().hide();

           try {
               Perehod.TransitionWindows(main1,"view_authorization",300,400,false);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       });
    }

    private void singUpNewUser() {

        DatebaseHendler dbHandler = new DatebaseHendler();

        String name=name_field.getText();
        String surname=surname_field.getText();
        String patronymic=patronymic_field.getText();
        String gender=gender_field.getValue();
        String dilution_date= String.valueOf(dilution_date_field.getValue());
        String login=login_field.getText();
        String password=password_field.getText();
        String passport_date=passport_date_field.getText();
        String phone=phone_field.getText();
        String mail=mail_field.getText();
        String role="client";

        User user = new User(name,surname,patronymic,gender,dilution_date,login,password,passport_date,phone,
                mail,role);

                dbHandler.singUpUser(user);


    }

}
