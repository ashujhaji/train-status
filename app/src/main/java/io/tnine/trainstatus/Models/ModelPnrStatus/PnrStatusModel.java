package io.tnine.trainstatus.Models.ModelPnrStatus;


        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import io.tnine.trainstatus.Models.FromStation;
        import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrain;
        import io.tnine.trainstatus.Models.Station;
        import io.tnine.trainstatus.Models.ToStation;

public class PnrStatusModel {

    @SerializedName("train")
    @Expose
    private LiveTrain train;
    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("pnr")
    @Expose
    private String pnr;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("journey_class")
    @Expose
    private JourneyClass journeyClass;
    @SerializedName("total_passengers")
    @Expose
    private Integer totalPassengers;
    @SerializedName("reservation_upto")
    @Expose
    private Station reservationUpto;
    @SerializedName("chart_prepared")
    @Expose
    private Boolean chartPrepared;
    @SerializedName("passengers")
    @Expose
    private List<Passenger> passengers = null;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;
    @SerializedName("boarding_point")
    @Expose
    private Station boardingPoint;
    @SerializedName("debit")
    @Expose
    private Integer debit;
    @SerializedName("doj")
    @Expose
    private String doj;

    public LiveTrain getTrain() {
        return train;
    }

    public void setTrain(LiveTrain train) {
        this.train = train;
    }

    public FromStation getFromStation() {
        return fromStation;
    }

    public void setFromStation(FromStation fromStation) {
        this.fromStation = fromStation;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public JourneyClass getJourneyClass() {
        return journeyClass;
    }

    public void setJourneyClass(JourneyClass journeyClass) {
        this.journeyClass = journeyClass;
    }

    public Integer getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(Integer totalPassengers) {
        this.totalPassengers = totalPassengers;
    }

    public Station getReservationUpto() {
        return reservationUpto;
    }

    public void setReservationUpto(Station reservationUpto) {
        this.reservationUpto = reservationUpto;
    }

    public Boolean getChartPrepared() {
        return chartPrepared;
    }

    public void setChartPrepared(Boolean chartPrepared) {
        this.chartPrepared = chartPrepared;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ToStation getToStation() {
        return toStation;
    }

    public void setToStation(ToStation toStation) {
        this.toStation = toStation;
    }

    public Station getBoardingPoint() {
        return boardingPoint;
    }

    public void setBoardingPoint(Station boardingPoint) {
        this.boardingPoint = boardingPoint;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

}
