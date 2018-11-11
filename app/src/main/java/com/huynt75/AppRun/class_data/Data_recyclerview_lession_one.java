package com.huynt75.AppRun.class_data;

public class Data_recyclerview_lession_one {
  private String title;
   private String mieuTa;
public Data_recyclerview_lession_one(String title, String mieuTa){
    this.mieuTa=mieuTa;
    this.title=title;
}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }
}
