package io.tnine.trainstatus.Utils;

import io.tnine.trainstatus.Models.ModelCancelledTrains.CancelledTrainsModel;
import io.tnine.trainstatus.Models.ModelFareEnquiry.FareEnquiryModel;
import io.tnine.trainstatus.Models.ModelLiveStationStatus.LiveStationStatusModel;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrainStatusModel;
import io.tnine.trainstatus.Models.ModelPnrStatus.PnrStatusModel;
import io.tnine.trainstatus.Models.ModelRescheduledTrains.RescheduledTrainsModel;
import io.tnine.trainstatus.Models.ModelSeatAvailability.SeatAvailabilityModel;
import io.tnine.trainstatus.Models.ModelTrainRoute.TrainRouteModel;
import io.tnine.trainstatus.Models.ModelTrainsBetweenStations.TrainsBetweenStationsModel;



public class Config {
    public static boolean decision = true;
    public static LiveTrainStatusModel liveTrainStatusModel;
    public static LiveStationStatusModel liveStationStatusModel;
    public static TrainsBetweenStationsModel trainsBetweenStationsModel;
    public static RescheduledTrainsModel rescheduledTrainsModel;
    public static SeatAvailabilityModel seatAvailabilityModel;
    public static String myApiKey;

    public static String getMyApiKey() {
        return myApiKey;
    }

    public static void setMyApiKey(String myApiKey) {
        Config.myApiKey = myApiKey;
    }

    public static SeatAvailabilityModel getSeatAvailabilityModel() {
        return seatAvailabilityModel;
    }

    public static void setSeatAvailabilityModel(SeatAvailabilityModel seatAvailabilityModel) {
        Config.seatAvailabilityModel = seatAvailabilityModel;
    }



    public static FareEnquiryModel getFareEnquiryModel() {
        return fareEnquiryModel;
    }

    public static void setFareEnquiryModel(FareEnquiryModel fareEnquiryModel) {
        Config.fareEnquiryModel = fareEnquiryModel;
    }

    public static FareEnquiryModel fareEnquiryModel;

    public static TrainRouteModel getTrainRouteModel() {
        return trainRouteModel;
    }

    public static void setTrainRouteModel(TrainRouteModel trainRouteModel) {
        Config.trainRouteModel = trainRouteModel;
    }

    public static TrainRouteModel trainRouteModel;

    public static CancelledTrainsModel getCancelledTrainsModel() {
        return cancelledTrainsModel;
    }

    public static void setCancelledTrainsModel(CancelledTrainsModel cancelledTrainsModel) {
        Config.cancelledTrainsModel = cancelledTrainsModel;
    }

    public static CancelledTrainsModel cancelledTrainsModel;

    public static RescheduledTrainsModel getRescheduledTrainsModel() {
        return rescheduledTrainsModel;
    }

    public static void setRescheduledTrainsModel(RescheduledTrainsModel rescheduledTrainsModel) {
        Config.rescheduledTrainsModel = rescheduledTrainsModel;
    }

    public static PnrStatusModel getPnrStatusModel() {
        return pnrStatusModel;
    }

    public static void setPnrStatusModel(PnrStatusModel pnrStatusModel) {
        Config.pnrStatusModel = pnrStatusModel;
    }

    public static PnrStatusModel pnrStatusModel;

    public static LiveStationStatusModel getLiveStationStatusModel() {
        return liveStationStatusModel;
    }

    public static void setLiveStationStatusModel(LiveStationStatusModel liveStationStatusModel) {
        Config.liveStationStatusModel = liveStationStatusModel;
    }

    public static TrainsBetweenStationsModel getTrainsBetweenStationsModel() {
        return trainsBetweenStationsModel;
    }

    public static void setTrainsBetweenStationsModel(TrainsBetweenStationsModel trainsBetweenStationsModel) {
        Config.trainsBetweenStationsModel = trainsBetweenStationsModel;
    }

    public static boolean isDecision() {
        return decision;
    }

    public static void setDecision(boolean decision) {
        Config.decision = decision;
    }

    public static LiveTrainStatusModel getLiveTrainStatusModel() {
        return liveTrainStatusModel;
    }

    public static void setLiveTrainStatusModel(LiveTrainStatusModel liveTrainStatusModel) {
        Config.liveTrainStatusModel = liveTrainStatusModel;
    }




}
