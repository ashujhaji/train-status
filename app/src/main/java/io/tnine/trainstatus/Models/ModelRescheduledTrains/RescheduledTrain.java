package io.tnine.trainstatus.Models.ModelRescheduledTrains;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.FromStation;
import io.tnine.trainstatus.Models.ToStation;

public class RescheduledTrain {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rescheduled_time")
    @Expose
    private String rescheduledTime;
    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("rescheduled_date")
    @Expose
    private String rescheduledDate;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("time_diff")
    @Expose
    private String timeDiff;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRescheduledTime() {
        return rescheduledTime;
    }

    public void setRescheduledTime(String rescheduledTime) {
        this.rescheduledTime = rescheduledTime;
    }

    public FromStation getFromStation() {
        return fromStation;
    }

    public void setFromStation(FromStation fromStation) {
        this.fromStation = fromStation;
    }

    public String getRescheduledDate() {
        return rescheduledDate;
    }

    public void setRescheduledDate(String rescheduledDate) {
        this.rescheduledDate = rescheduledDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(String timeDiff) {
        this.timeDiff = timeDiff;
    }

    public ToStation getToStation() {
        return toStation;
    }

    public void setToStation(ToStation toStation) {
        this.toStation = toStation;
    }

}
