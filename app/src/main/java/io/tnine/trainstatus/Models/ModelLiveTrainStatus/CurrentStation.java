package io.tnine.trainstatus.Models.ModelLiveTrainStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentStation {

    @SerializedName("lng")
    @Expose
    private Float lng;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private Float lat;

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

}