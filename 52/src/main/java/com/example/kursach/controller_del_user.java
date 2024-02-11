    package com.example.kursach;

    import java.net.URL;
    import java.util.ResourceBundle;
    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.AnchorPane;

    public class controller_del_user {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button del_button;

        @FXML
        private TextField login_field;

        @FXML
        private AnchorPane main1;

        @FXML
        private TextField password_field;

        @FXML
        void initialize() {
            del_button.setOnAction(event -> {
                String loginText = login_field.getText().trim();
                String role=Const.rollers;
                delet_user(loginText,role);
                del_button.getScene().getWindow().hide();
            });

        }

        private void delet_user(String loginText, String role) {
            DatebaseHendler dbHandler = new DatebaseHendler();
            dbHandler.delet_user(loginText, role);

        }

    }
