package io.tnine.trainstatus.Models.ModelTrainRoute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.Station;

public class Route {

    @SerializedName("station")
    @Expose
    private Station station;
    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("schdep")
    @Expose
    private String schdep;
    @SerializedName("no")
    @Expose
    private Integer no;
    @SerializedName("scharr")
    @Expose
    private String scharr;
    @SerializedName("halt")
    @Expose
    private Integer halt;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public Integer getHalt() {
        return halt;
    }

    public void setHalt(Integer halt) {
        this.halt = halt;
    }

}