package io.tnine.trainstatus.Models.StationAutoCompleteSuggestions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tnine.trainstatus.Models.Station;

public class StationAutoCompleteSuggest {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("stations")
    @Expose
    private List<Station> stations = null;
    @SerializedName("debit")
    @Expose
    private Integer debit;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

}


