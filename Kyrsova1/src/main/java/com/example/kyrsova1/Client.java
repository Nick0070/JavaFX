
package com.example.kyrsova1;

public class Client extends Const {
    // Поля таблицы клиентов
    private int idClient;
    private String name;
    private String searname;
    private String patronomik;
    private String carname;
    private String carnumber;

    // Геттеры и сеттеры для полей

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearname() {
        return searname;
    }

    public void setSearname(String searname) {
        this.searname = searname;
    }

    public String getPatronomik() {
        return patronomik;
    }

    public void setPatronomik(String patronomik) {
        this.patronomik = patronomik;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }
}
