package io.tnine.trainstatus.Models.ModelTrainsBetweenStations;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.Class;
import io.tnine.trainstatus.Models.Day;
import io.tnine.trainstatus.Models.FromStation;
import io.tnine.trainstatus.Models.ToStation;

public class TrainsBetweenStations {

    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("src_departure_time")
    @Expose
    private String srcDepartureTime;
    @SerializedName("travel_time")
    @Expose
    private String travelTime;
    @SerializedName("classes")
    @Expose
    private List<Class> classes = null;
    @SerializedName("days")
    @Expose
    private List<Day> days = null;
    @SerializedName("dest_arrival_time")
    @Expose
    private String destArrivalTime;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;
    @SerializedName("number")
    @Expose
    private String number;

    public FromStation getFromStation() {
        return fromStation;
    }

    public void setFromStation(FromStation fromStation) {
        this.fromStation = fromStation;
    }

    public String getSrcDepartureTime() {
        return srcDepartureTime;
    }

    public void setSrcDepartureTime(String srcDepartureTime) {
        this.srcDepartureTime = srcDepartureTime;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public String getDestArrivalTime() {
        return destArrivalTime;
    }

    public void setDestArrivalTime(String destArrivalTime) {
        this.destArrivalTime = destArrivalTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToStation getToStation() {
        return toStation;
    }

    public void setToStation(ToStation toStation) {
        this.toStation = toStation;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}