package io.tnine.trainstatus.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FromStation {

    @SerializedName("lat")
    @Expose
    private Float lat;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("lng")
    @Expose
    private Float lng;
    @SerializedName("name")
    @Expose
    private String name;

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}