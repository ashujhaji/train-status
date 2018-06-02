package io.tnine.trainstatus.Models.ModelTrainRoute;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrain;

public class TrainRouteModel {

    @SerializedName("route")
    @Expose
    private List<Route> route = null;
    @SerializedName("train")
    @Expose
    private LiveTrain train;
    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public LiveTrain getTrain() {
        return train;
    }

    public void setTrain(LiveTrain train) {
        this.train = train;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

}

