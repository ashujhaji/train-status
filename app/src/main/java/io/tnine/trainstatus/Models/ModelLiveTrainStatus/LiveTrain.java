package io.tnine.trainstatus.Models.ModelLiveTrainStatus;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.Day;

public class LiveTrain {

    @SerializedName("classes")
    @Expose
    private List<LiveTrainClass> classes = null;
    @SerializedName("days")
    @Expose
    private List<Day> days = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number")
    @Expose
    private String number;

    public List<LiveTrainClass> getClasses() {
        return classes;
    }

    public void setClasses(List<LiveTrainClass> classes) {
        this.classes = classes;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}