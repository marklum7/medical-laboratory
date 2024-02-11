package com.example.kursach;

public class User {
    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private String dilution_date;
    private String login;
    private String password;
    private String passport_date;
    private String phone;

    private String mail;
    private String role;

    public User(String name, String surname, String patronymic, String gender, String dilution_date, String login, String password, String passport_date, String phone, String mail, String role) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dilution_date = dilution_date;
        this.login = login;
        this.password = password;
        this.passport_date = passport_date;
        this.phone = phone;
        this.mail = mail;
        this.role = role;
    }

    public User() {

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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDilution_date() {
        return dilution_date;
    }

    public void setDilution_date(String dilution_date) {
        this.dilution_date = dilution_date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassport_date() {
        return passport_date;
    }

    public void setPassport_date(String passport_date) {
        this.passport_date = passport_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

