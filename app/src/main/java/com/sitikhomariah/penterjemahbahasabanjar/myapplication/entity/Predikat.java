package com.sitikhomariah.penterjemahbahasabanjar.myapplication.entity;

public class Predikat {
    private int id;
    private String Banjar;
    private String Indonesia;

    public Predikat() {
    }

    public Predikat(int id, String banjar, String indonesia) {
        this.id = id;
        Banjar = banjar;
        Indonesia = indonesia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBanjar() {
        return Banjar;
    }

    public void setBanjar(String banjar) {
        Banjar = banjar;
    }

    public String getIndonesia() {
        return Indonesia;
    }

    public void setIndonesia(String indonesia) {
        Indonesia = indonesia;
    }

}
