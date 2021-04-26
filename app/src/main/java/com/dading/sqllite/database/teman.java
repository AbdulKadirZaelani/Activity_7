package com.dading.sqllite.database;

public class teman {
    String id;
    String teman;
    String telpon;

    public teman() {
    }

    public teman(String id, String teman, String telpon) {
        this.id = id;
        this.teman = teman;
        this.telpon = telpon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeman() {
        return teman;
    }

    public void setTeman(String teman) {
        this.teman = teman;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }
}
