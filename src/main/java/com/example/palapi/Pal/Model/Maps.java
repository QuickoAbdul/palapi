package com.example.palapi.Pal.Model;

public class Maps {
    public String day;
    public String night;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String toString() {
        return "Maps{" +
                "day='" + day + '\'' +
                ", night='" + night + '\'' +
                '}';
    }

}
