package com.example.kursach;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatebaseHendler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException,SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"
                +dbPost+"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection=DriverManager.getConnection(connectionString,dbUser,
                dbPass);
        return dbConnection;
    }

    public void singUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE+"("+
                Const.USER_NAME+","+Const.USER_SURNAME+","+Const.USER_PATRONYMIC+","+Const.USER_GENDER+","+
                Const.USER_DATE+","+Const.USER_LOGIN+","+Const.USER_PASSWORD+","+Const.USER_PASSPORT_DATA+","+
                Const.USER_PHONE+","+Const.USER_MAIL+","+Const.USER_ROLE+")"+
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";


        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(insert);            prSt.setString(2, user.getSurname());
            prSt.setString(3, user.getPatronymic());
            prSt.setString(4, user.getGender());
            prSt.setString(5, user.getDilution_date());
            prSt.setString(6, user.getLogin());
            prSt.setString(7, user.getPassword());
            prSt.setString(8, user.getPassport_date());
            prSt.setString(9, user.getPhone());
            prSt.setString(10, user.getMail());
            prSt.setString(11, user.getRole());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void delet_user(String login, String role){
        String qwery = "DELETE FROM "+ Const.USER_TABLE+" WHERE "+Const.USER_LOGIN+"='"+login+
                "' AND "+ Const.USER_ROLE+ "='"+role+"';";
        try {
            Statement prSt=getDbConnection().createStatement();
            prSt.execute(qwery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM "+Const.USER_TABLE+
                " WHERE "+Const.USER_LOGIN+"=? AND "+
                Const.USER_PASSWORD+"=?";
        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet=prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }

    public void singAnalis(Analysis analysis) {
        String inserts = "INSERT INTO " + Const.ANALYSIS_TABLE+"("+
                Const.ANALYSIS_USER_ID+","+Const.ANALYSIS_NAME+","+Const.ANALYSIS_TYPE+","+
                Const.ANALYSIS_DELIVERY+","+Const.ANALYSIS_STATUS+")"+
                "VALUES(?,?,?,?,?)";


        try {
            PreparedStatement prSt=getDbConnection().prepareStatement(inserts);
            prSt.setString(1, analysis.getId_user());
            prSt.setString(2, analysis.getName_analysis());
            prSt.setString(3, analysis.getType_biomaterial());
            prSt.setString(4, analysis.getDelivery());
            prSt.setString(5, analysis.getReady_status());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void editUser(String name, String surname, String patronymic, String gender, String dilution_date, String login, String password, String passport_date, String phone, String mail, String role) {
        String inserts = "UPDATE "+Const.USER_TABLE+" SET "+Const.USER_NAME+"='"+name+"', "+Const.USER_SURNAME+
                "='"+surname+"', "+Const.USER_PATRONYMIC+ "='"+patronymic+"', "+Const.USER_GENDER+ "='"+gender+
                "', "+Const.USER_DATE+ "='"+dilution_date+"', "+Const.USER_LOGIN+ "='"+login+"', "+Const.USER_PASSWORD+ "='"+password+"', "+
                Const.USER_PASSPORT_DATA+ "='"+passport_date+"', "+Const.USER_PHONE+ "='"+phone+"', "+Const.USER_MAIL+ "='"+mail+
                "' WHERE ("+Const.USER_ID+" = "+User_info.id+");";


        try {
            Statement prSt=getDbConnection().createStatement();
            prSt.execute(inserts);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<Table_analysis> completeTable1(String x){
        ObservableList<Table_analysis>  table1 = FXCollections.observableArrayList();
        String inserts = "SELECT name, surname, name_analysis, type_biomaterial, delivery, ready_status FROM user inner join analysis on user.id_user=analysis.id_user";
        try {

            Statement prSt=getDbConnection().createStatement();
            ResultSet result = prSt.executeQuery(inserts);
            while (result.next()){
                if (!x.equals("") && result.getString("ready_status").equals(x)){
                    table1.add(new Table_analysis(result.getString("name"),result.getString("surname"),
                            result.getString("name_analysis"),result.getString("type_biomaterial"),
                            result.getString("delivery"),result.getString("ready_status")));
                }
                else if(x.equals("")){
                    table1.add(new Table_analysis(result.getString("name"),result.getString("surname"),
                            result.getString("name_analysis"),result.getString("type_biomaterial"),
                            result.getString("delivery"),result.getString("ready_status")));
                }

            }
            return table1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ObservableList<Table_profil> completeTable2(){
        ObservableList<Table_profil>  table2 = FXCollections.observableArrayList();
        String inserts = "SELECT name_analysis, type_biomaterial, delivery, ready_status FROM analysis where id_user = "+User_info.id;
        try {

            Statement prSt=getDbConnection().createStatement();
            ResultSet result = prSt.executeQuery(inserts);
            while (result.next()){

                table2.add(new Table_profil(result.getString("name_analysis"),result.getString("type_biomaterial"),
                        result.getString("delivery"),result.getString("ready_status")));


            }
            return table2;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ObservableList<Table_users> completeTable3(String x){
        ObservableList<Table_users>  table3 = FXCollections.observableArrayList();
        String inserts = "SELECT * FROM user";
        try {

            Statement prSt=getDbConnection().createStatement();
            ResultSet result = prSt.executeQuery(inserts);
            while (result.next()){
                if (!x.equals("") && result.getString("role").equals(x)){

                    table3.add(new Table_users(result.getString("id_user"),result.getString("name"),
                            result.getString("surname"),result.getString("patronymic"),
                            result.getString("gender"),result.getString("dilution_date"),result.getString("login")
                            ,result.getString("password"),result.getString("passport_date"),result.getString("phone"),result.getString("mail"),result.getString("role")));
                }
                else if(x.equals("")){
                    table3.add(new Table_users(result.getString("id"),result.getString("name"),
                            result.getString("surname"),result.getString("patronymic"),
                            result.getString("gender"),result.getString("dilution_date"),result.getString("login")
                            ,result.getString("password"),result.getString("passport_date"),result.getString("phone"),result.getString("mail"),result.getString("role")));
                }

            }
            return table3;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
