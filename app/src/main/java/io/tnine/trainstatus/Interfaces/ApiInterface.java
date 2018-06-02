package io.tnine.trainstatus.Interfaces;

import io.tnine.trainstatus.Models.ModelFareEnquiry.FareEnquiryModel;
import io.tnine.trainstatus.Models.ModelLiveStationStatus.LiveStationStatusModel;
import io.tnine.trainstatus.Models.ModelPnrStatus.PnrStatusModel;
import io.tnine.trainstatus.Models.ModelRescheduledTrains.RescheduledTrainsModel;
import io.tnine.trainstatus.Models.ModelSeatAvailability.SeatAvailabilityModel;
import io.tnine.trainstatus.Models.ModelTrainRoute.TrainRouteModel;
import io.tnine.trainstatus.Utils.Config;
import io.tnine.trainstatus.Utils.Constants;
import io.tnine.trainstatus.Models.ModelCancelledTrains.CancelledTrainsModel;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrainStatusModel;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrainsModel;
import io.tnine.trainstatus.Models.StationAutoCompleteSuggestions.StationAutoCompleteSuggest;
import io.tnine.trainstatus.Models.ModelTrainsBetweenStations.TrainsBetweenStationsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiInterface {



    @GET("cancelled/date/{date_for}/apikey/{api_key}/")                                             //Cancelled Trains
    Call<CancelledTrainsModel> getCancelledTrains(
            @Path("date_for") String date,
            @Path("api_key") String apiKey);


    @GET("suggest-station/name/{partial_stn_name}/apikey/" + Constants.API_KEY + "/")               //Stations suggestions
    Call<StationAutoCompleteSuggest> getStationSuggestions(
            @Path("partial_stn_name") CharSequence partialStationName);


    @GET("between/source/{src_stn_code}/dest/{dest_stn_code}/date/{trains_bw_date}/apikey/" + Constants.API_KEY + "/")
    Call<TrainsBetweenStationsModel> getTrainsBetweenStations(                                      //Trains Between Stations
            @Path("src_stn_code") String sourceStationCode,
            @Path("dest_stn_code") String destinationStationCode,
            @Path("trains_bw_date") String trainsBetweenStationsDate);

    @GET("live/train/{train_number}/date/{live_train_date}/apikey/" + Constants.API_KEY + "/")      //Live Train Status
    Call<LiveTrainStatusModel> getLiveTrainStatus(
            @Path("train_number") String trainNumber,
            @Path("live_train_date") String liveTrainStatusDate);


    @GET("suggest-train/train/{partial_train_name_or_number}/apikey/" + Constants.API_KEY + "/")    //Train Suggestions
    Call<LiveTrainsModel> getTrainSuggestions(
            @Path("partial_train_name_or_number") String trainKeyword);


    @GET("rescheduled/date/{date_rescheduled}/apikey/" + Constants.API_KEY + "/")                   //Rescheduled Trains
    Call<RescheduledTrainsModel> getRescheduledTrains(
            @Path("date_rescheduled") String date);


    @GET("route/train/{train_number}/apikey/" + Constants.API_KEY + "/")                            //Train Route
    Call<TrainRouteModel> getTrainRoute(
            @Path("train_number") String trainNumber);


    @GET("pnr-status/pnr/{pnr_no}/apikey/" + Constants.API_KEY + "/")                               //PNR Status
    Call<PnrStatusModel> getPnrStatus(
            @Path("pnr_no") String pnrNumber);


    @GET("arrivals/station/{stn_code}/hours/{window_period_in_hours}/apikey/" + Constants.API_KEY + "/")
    Call<LiveStationStatusModel> getTrainArrivals(                                                  //Train Arrivals
            @Path("stn_code") String stationCode,
            @Path("window_period_in_hours") String hours
    );

    @GET("check-seat/train/{train_number}/source/{src_stn_code}/dest/{dest_stn_code}/date/{date}/pref/{class_code}/quota/{quota_code}/apikey/" + Constants.API_KEY + "/")
    Call<SeatAvailabilityModel> getSeatAvailability(
            @Path("train_number") String trainNumber,
            @Path("src_stn_code") String sourceStationCode,
            @Path("dest_stn_code") String destinationStationCode,
            @Path("date") String date,
            @Path("class_code") String classCode,
            @Path("quota_code") String quotaCode
    );

    @GET("fare/train/{train_number}/source/{src_stn_code}/dest/{dest_stn_code}/age/{age}/pref/{class_code}/quota/{quota_code}/date/{date}/apikey/" + Constants.API_KEY + "/")
    Call<FareEnquiryModel> getFareEnquiry(
            @Path("train_number") String trainNumber,
            @Path("src_stn_code") String sourceStationCode,
            @Path("dest_stn_code") String destinationStationCode,
            @Path("age") String age,
            @Path("class_code") String classCode,
            @Path("quota_code") String quotaCode,
            @Path("date") String date
    );


    @GET("code-to-name/code/{stn_code}/apikey/" + Constants.API_KEY + "/")
    Call<StationAutoCompleteSuggest> getStationsFromCode(
        @Path("stn_code") CharSequence stationCode
    );


}
