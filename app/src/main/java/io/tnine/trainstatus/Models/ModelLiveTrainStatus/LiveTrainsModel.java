package io.tnine.trainstatus.Models.ModelLiveTrainStatus;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiveTrainsModel {

    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("trains")
    @Expose
    private List<LiveTrain> trains = null;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public List<LiveTrain> getTrains() {
        return trains;
    }

    public void setTrains(List<LiveTrain> trains) {
        this.trains = trains;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

}