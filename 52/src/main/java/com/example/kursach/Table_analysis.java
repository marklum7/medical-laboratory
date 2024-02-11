package com.example.kursach;

public class Table_analysis {
    private String name;
    private String surname;
    private String name_analysis;
    private String type_analysis;
    private String data_analysis;
    private String status;

    public Table_analysis(String name, String surname, String name_analysis, String type_analysis, String data_analysis, String status) {
        this.name = name;
        this.surname = surname;
        this.name_analysis = name_analysis;
        this.type_analysis = type_analysis;
        this.data_analysis = data_analysis;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surmane) {
        this.surname = surmane;
    }

    public String getName_analysis() {
        return name_analysis;
    }

    public void setName_analysis(String name_analysis) {
        this.name_analysis = name_analysis;
    }

    public String getType_analysis() {
        return type_analysis;
    }

    public void setType_analysis(String type_analysis) {
        this.type_analysis = type_analysis;
    }

    public String getData_analysis() {
        return data_analysis;
    }

    public void setData_analysis(String data_analysis) {
        this.data_analysis = data_analysis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
