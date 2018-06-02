package io.tnine.trainstatus.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("has_arrived")
    @Expose
    private Boolean hasArrived;
    @SerializedName("actdep")
    @Expose
    private String actdep;
    @SerializedName("latemin")
    @Expose
    private Integer latemin;
    @SerializedName("scharr")
    @Expose
    private String scharr;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("station")
    @Expose
    private Station station;
    @SerializedName("scharr_date")
    @Expose
    private String scharrDate;
    @SerializedName("has_departed")
    @Expose
    private Boolean hasDeparted;
    @SerializedName("actarr")
    @Expose
    private String actarr;
    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("schdep")
    @Expose
    private String schdep;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("actarr_date")
    @Expose
    private String actarrDate;

    public Boolean getHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(Boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public Integer getLatemin() {
        return latemin;
    }

    public void setLatemin(Integer latemin) {
        this.latemin = latemin;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getScharrDate() {
        return scharrDate;
    }

    public void setScharrDate(String scharrDate) {
        this.scharrDate = scharrDate;
    }

    public Boolean getHasDeparted() {
        return hasDeparted;
    }

    public void setHasDeparted(Boolean hasDeparted) {
        this.hasDeparted = hasDeparted;
    }

    public String getActarr() {
        return actarr;
    }

    public void setActarr(String actarr) {
        this.actarr = actarr;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActarrDate() {
        return actarrDate;
    }

    public void setActarrDate(String actarrDate) {
        this.actarrDate = actarrDate;
    }

}