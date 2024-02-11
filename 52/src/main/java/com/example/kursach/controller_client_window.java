package com.example.kursach;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class controller_client_window {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_button;

    @FXML
    private Button back_button;
    @FXML
    private TableView<Table_profil> info_analysis;

    @FXML
    private TextField ves;

    @FXML
    private TextField onvet;

    @FXML
    private TextField rost;

    @FXML
    private TextField imt;

    @FXML
    private Button add_button2;

    @FXML
    private Hyperlink change_button;

    @FXML
    private TableColumn<Table_profil, String> data_analysis;

    @FXML
    private DatePicker date_researches;

    @FXML
    private Label dilution_date;

    @FXML
    private Label login;

    @FXML
    private Label name;

    @FXML
    private TableColumn<Table_profil, String> name_analysis;

    @FXML
    private ComboBox<String> name_researches;

    @FXML
    private TableColumn<Table_profil, String> status_analysis;

    @FXML
    private Label surname;

    @FXML
    private TableColumn<Table_profil, String> type_analysis;

    @FXML
    private AnchorPane main1;

    @FXML
    private ComboBox<String> type_researches;

    @FXML
    void Accounts_Click(MouseEvent event) {
    }

    @FXML
    void initialize() {
        addtable();

        Const.scene = this;
        change_button.setOnAction(event -> {
            Const.rollers="client";
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

        type_researches.getItems().addAll("Анализ крови","Анализ мочи","Анализ кала",
        "Микробиология");


        type_researches.setOnAction(event -> {
            name_researches.getItems().clear();
            String type=type_researches.getValue();
            if (type=="Анализ крови"){
                name_researches.getItems().addAll("Общий анализ крови","Биохимический анализ крови","Определение группы и резус-фактора крови"
                        ,"Коагулограмма","Анализ крови на сахар","Анализ крови на гормоны","Иммунологический и аллергологический анализ крови","Анализ крови на ПЦР","Исследование на ХГЧ","Анализ крови на паразитов"
                        ,"Исследование крови на наличие онкомаркеров","Анализ крови на микроэлементы");
            }
            if (type=="Анализ мочи"){
                name_researches.getItems().addAll("Общий анализ мочи","Анализ мочи по Нечипоренко","Анализ мочи на лейкоциты"
                        ,"Анализ мочи при беременности","Биохимический анализ мочи","Анализ мочи по Зимницкому","Двухстаканная проба","Трехстаканная проба");
            }
            if (type=="Анализ кала"){
                name_researches.getItems().addAll("Общий анализ кала","Исследование кала на скрытую кровь","Анализ кала на простейших и яйца гельминтов","Панкреатическая эластаза l в кале"
                        ,"Углеводы в кале","Биохимический анализ дисбактериоза кишечника","Ротавирус в кале","Аденовирус в кале","Антиген лямблии в кале"
                        ,"Зонулин","Кальпротектин");
            }
            if (type=="Микробиология"){
                name_researches.getItems().addAll("Микробиологический анализ мочи","Микробиологический анализ кала","Микробиологический анализ крови","Микробиологический анализ мазка");
            }
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
        add_button.setOnAction(event ->{

            singUpNewAnalis();
            addtable();

        });
        add_button2.setOnAction(event ->{
            Float vess = Float.parseFloat(ves.getText());
            Float rosts = Float.parseFloat(rost.getText());

            Float IMT = vess / (rosts*rosts);
            IMT= (float) Math.floor(IMT);

            imt.setText(String.valueOf(IMT));
            if (IMT<=16){
                onvet.setText("Выраженный дефицит массы тела");
            }
            if (IMT>16&&IMT<=19){
                onvet.setText("Недостаточная масса тела");
            }
            if (IMT>19&&IMT<=25){
                onvet.setText("Норма");
            }
            if (IMT>25&&IMT<=30){
                onvet.setText("Избыточная масса тела");
            }
            if (IMT>30&&IMT<=35){
                onvet.setText("Ожирение первой степени");
            }
            if (IMT>35&&IMT<40){
                onvet.setText("Ожирение второй степени");
            }
            if (IMT>40){
                onvet.setText("Ожирение третьей степени");
            }





        });

    }

    void UpdateData(){
        name.setText(User_info.name);
        surname.setText(User_info.surname);
        dilution_date.setText(User_info.dilution_date);
        login.setText(User_info.login);
    }

    private void singUpNewAnalis() {

        DatebaseHendler dbHandler = new DatebaseHendler();
        String id_user=User_info.id;
        String name_analysis=name_researches.getValue();
        String type_biomaterial=type_researches.getValue();
        String delivery=String.valueOf(date_researches.getValue());
        String ready_status="-";


            Analysis analysis = new Analysis(id_user,name_analysis,type_biomaterial,delivery,ready_status);

            dbHandler.singAnalis(analysis);

    }
    private void addtable(){DatebaseHendler dbHandler = new DatebaseHendler();
        ObservableList<Table_profil> tables = dbHandler.completeTable2();
        name_analysis.setCellValueFactory(new PropertyValueFactory<Table_profil, String>("name_analysis"));
        type_analysis.setCellValueFactory(new PropertyValueFactory<Table_profil, String>("type_biomaterial"));
        data_analysis.setCellValueFactory(new PropertyValueFactory<Table_profil, String>("delivery"));
        status_analysis.setCellValueFactory(new PropertyValueFactory<Table_profil, String>("ready_status"));
        info_analysis.refresh();
        info_analysis.setItems(tables);
    }

}
