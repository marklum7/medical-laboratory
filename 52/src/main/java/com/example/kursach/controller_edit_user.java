package com.example.kursach;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class controller_edit_user {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker dilution_date_field;

    @FXML
    private Button edit_button;

    @FXML
    private ComboBox<String> gender_field;

    @FXML
    private TextField login_field;

    @FXML
    private TextField mail_field;

    @FXML
    private AnchorPane main1;

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
    private TextField surname_field;

    @FXML
    void initialize() {
        gender_field.getItems().addAll("Мужской","Женский");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        name_field.setText(User_info.name);
        surname_field.setText(User_info.surname);
        patronymic_field.setText(User_info.patronymic);
        gender_field.setValue(User_info.gender);
        dilution_date_field.setValue(LocalDate.parse(User_info.dilution_date,formatter));
        login_field.setText(User_info.login);
        password_field.setText(User_info.password);
        passport_date_field.setText(User_info.passport_date);
        phone_field.setText(User_info.phone);
        mail_field.setText(User_info.mail);
        edit_button.setOnAction(event ->{
            editUser();
            edit_button.getScene().getWindow().hide();
            Const.scene.UpdateData();

        });

    }

    private void editUser() {
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
        String role=Const.rollers;

        User_info.name=name;
        User_info.surname=surname;
        User_info.patronymic=patronymic;
        User_info.gender=gender;
        User_info.dilution_date=dilution_date;
        User_info.login=login;
        User_info.password=password;
        User_info.passport_date=passport_date;
        User_info.phone=phone;
        User_info.mail=mail;


        dbHandler.editUser(name,surname,patronymic,gender,dilution_date,login,password,passport_date,phone,mail,
                role);



    }

}
