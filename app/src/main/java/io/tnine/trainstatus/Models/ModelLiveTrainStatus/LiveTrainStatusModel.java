package io.tnine.trainstatus.Models.ModelLiveTrainStatus;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.Route;

public class LiveTrainStatusModel {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("train")
    @Expose
    private LiveTrain train;
    @SerializedName("route")
    @Expose
    private List<Route> route = null;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("current_station")
    @Expose
    private CurrentStation currentStation;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LiveTrain getTrain() {
        return train;
    }

    public void setTrain(LiveTrain train) {
        this.train = train;
    }

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public CurrentStation getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(CurrentStation currentStation) {
        this.currentStation = currentStation;
    }

}