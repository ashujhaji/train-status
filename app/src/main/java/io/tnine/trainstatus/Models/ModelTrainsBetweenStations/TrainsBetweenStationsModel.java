package io.tnine.trainstatus.Models.ModelTrainsBetweenStations;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrainsBetweenStationsModel {

    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("trains")
    @Expose
    private List<TrainsBetweenStations> trains = null;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public List<TrainsBetweenStations> getTrains() {
        return trains;
    }

    public void setTrains(List<TrainsBetweenStations> trains) {
        this.trains = trains;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}