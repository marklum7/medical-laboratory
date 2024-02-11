package com.example.kursach;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class controller_add_user {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker dilution_date_field;

    @FXML
    private ComboBox<String> gender_field;

    @FXML
    private TextField login_field;

    @FXML
    private TextField mail_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField passport_date_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField patronymic_field;

    @FXML
    private TextField phone_field;

    @FXML
    private Button registration_button;

    @FXML
    private TextField surname_field;


    @FXML
    void initialize() {
        gender_field.getItems().addAll("Мужской","Женский");
        registration_button.setOnAction(event ->{
            singUpNewUser();
            registration_button.getScene().getWindow().hide();
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
        String role= Const.rollers;

        User user = new User(name,surname,patronymic,gender,dilution_date,login,password,passport_date,phone,
                mail,role);

        dbHandler.singUpUser(user);


    }

}
