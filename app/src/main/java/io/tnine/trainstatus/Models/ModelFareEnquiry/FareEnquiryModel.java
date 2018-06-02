package io.tnine.trainstatus.Models.ModelFareEnquiry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.FromStation;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrain;
import io.tnine.trainstatus.Models.ModelPnrStatus.JourneyClass;
import io.tnine.trainstatus.Models.ModelSeatAvailability.Quota;
import io.tnine.trainstatus.Models.ToStation;

public class FareEnquiryModel {

    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;
    @SerializedName("fare")
    @Expose
    private Integer fare;
    @SerializedName("train")
    @Expose
    private LiveTrain train;
    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("quota")
    @Expose
    private Quota quota;
    @SerializedName("journey_class")
    @Expose
    private JourneyClass journeyClass;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;

    public FromStation getFromStation() {
        return fromStation;
    }

    public void setFromStation(FromStation fromStation) {
        this.fromStation = fromStation;
    }

    public ToStation getToStation() {
        return toStation;
    }

    public void setToStation(ToStation toStation) {
        this.toStation = toStation;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
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

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public JourneyClass getJourneyClass() {
        return journeyClass;
    }

    public void setJourneyClass(JourneyClass journeyClass) {
        this.journeyClass = journeyClass;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

}