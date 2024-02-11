package com.example.kursach;

public class Analysis {
    private String id_user;
    private String name_analysis;
    private String type_biomaterial;
    private String delivery;
    private String ready_status;
    public String getId_user() {
        return id_user;
    }
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    public String getName_analysis() {
        return name_analysis;
    }
    public void setName_analysis(String name_analysis) {
        this.name_analysis = name_analysis;
    }
    public String getType_biomaterial() {
        return type_biomaterial;
    }
    public void setType_biomaterial(String type_biomaterial) {
        this.type_biomaterial = type_biomaterial;
    }
    public String getDelivery() {
        return delivery;
    }
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
    public String getReady_status() {
        return ready_status;
    }
    public void setReady_status(String ready_status) {
        this.ready_status = ready_status;
    }

    public Analysis(String id_user, String name_analysis, String type_biomaterial, String delivery,String ready_status) {
        this.id_user = id_user;
        this.name_analysis = name_analysis;
        this.type_biomaterial = type_biomaterial;
        this.delivery = delivery;
        this.ready_status = ready_status;
    }

}
