package io.tnine.trainstatus.Models.ModelSeatAvailability;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.FromStation;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrain;
import io.tnine.trainstatus.Models.ModelPnrStatus.JourneyClass;
import io.tnine.trainstatus.Models.ToStation;

public class SeatAvailabilityModel {

    @SerializedName("journey_class")
    @Expose
    private JourneyClass journeyClass;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;
    @SerializedName("availability")
    @Expose
    private List<Availability> availability = null;
    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("quota")
    @Expose
    private Quota quota;
    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("train")
    @Expose
    private LiveTrain train;

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

    public ToStation getToStation() {
        return toStation;
    }

    public void setToStation(ToStation toStation) {
        this.toStation = toStation;
    }

    public List<Availability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    public FromStation getFromStation() {
        return fromStation;
    }

    public void setFromStation(FromStation fromStation) {
        this.fromStation = fromStation;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public LiveTrain getTrain() {
        return train;
    }

    public void setTrain(LiveTrain train) {
        this.train = train;
    }

}