package io.tnine.trainstatus.Models.ModelRescheduledTrains;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RescheduledTrainsModel {

    @SerializedName("trains")
    @Expose
    private List<RescheduledTrain> trains = null;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("debit")
    @Expose
    private Integer debit;

    public List<RescheduledTrain> getTrains() {
        return trains;
    }

    public void setTrains(List<RescheduledTrain> trains) {
        this.trains = trains;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

}
