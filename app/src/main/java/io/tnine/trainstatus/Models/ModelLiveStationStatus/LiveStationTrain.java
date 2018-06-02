package io.tnine.trainstatus.Models.ModelLiveStationStatus;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveStationTrain {
    @SerializedName("actarr")
    @Expose
    private String actarr;
    @SerializedName("scharr")
    @Expose
    private String scharr;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("schdep")
    @Expose
    private String schdep;
    @SerializedName("delaydep")
    @Expose
    private String delaydep;
    @SerializedName("actdep")
    @Expose
    private String actdep;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("delayarr")
    @Expose
    private String delayarr;

    public String getActarr() {
        return actarr;
    }

    public void setActarr(String actarr) {
        this.actarr = actarr;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public String getDelaydep() {
        return delaydep;
    }

    public void setDelaydep(String delaydep) {
        this.delaydep = delaydep;
    }

    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDelayarr() {
        return delayarr;
    }

    public void setDelayarr(String delayarr) {
        this.delayarr = delayarr;
    }

}
