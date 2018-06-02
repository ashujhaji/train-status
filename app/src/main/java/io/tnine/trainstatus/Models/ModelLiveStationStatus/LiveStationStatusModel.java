package io.tnine.trainstatus.Models.ModelLiveStationStatus;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveStationStatusModel {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("trains")
    @Expose
    private List<LiveStationTrain> trains = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("debit")
    @Expose
    private Integer debit;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<LiveStationTrain> getTrains() {
        return trains;
    }

    public void setTrains(List<LiveStationTrain> trains) {
        this.trains = trains;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

}