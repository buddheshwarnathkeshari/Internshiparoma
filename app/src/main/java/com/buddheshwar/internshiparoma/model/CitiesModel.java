package com.buddheshwar.internshiparoma.model;

public class CitiesModel {
    private int mcityimageresource;
    private String mcityname;
    public CitiesModel(int cityimageresource,String cityname){
        this.mcityimageresource=cityimageresource;
        this.mcityname=cityname;
    }
    public int getCityimageresource() {
        return mcityimageresource;
    }

    public String getCityname() {
        return mcityname;
    }

    public void setCityimageresource(int cityimageresource) {
        this.mcityimageresource = cityimageresource;
    }

    public void setCityname(String cityname) {
        this.mcityname = cityname;
    }
}
