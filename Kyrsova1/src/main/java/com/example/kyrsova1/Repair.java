package com.example.kyrsova1;

public class Repair extends Const {
    // Поля таблицы ремонта
    private int idzaphasti;
    private String Name;
    private String kolvo;
    private String marka;
    private String yearproizvod;

    // Геттеры и сеттеры для полей

    public int getIdZapchasti() {
        return idzaphasti;
    }

    public void setIdZapchasti(int idzaphasti) {
        this.idzaphasti = idzaphasti;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getKolvo() {
        return kolvo;
    }

    public void setKolvo(String kolvo) {
        this.kolvo = kolvo;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getYearproizvod() {
        return yearproizvod;
    }

    public void setYearproizvod(String yearproizvod) {
        this.yearproizvod = yearproizvod;
    }
}
