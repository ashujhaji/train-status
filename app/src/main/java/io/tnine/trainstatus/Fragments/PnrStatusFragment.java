package io.tnine.trainstatus.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.tnine.trainstatus.Models.ModelPnrStatus.PnrStatusModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;


public class PnrStatusFragment extends Fragment {

    PnrStatusModel model;


    public PnrStatusFragment() {
        model = Config.getPnrStatusModel();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pnr_status, container, false);

        TextView textPassengersVal = view.findViewById(R.id.tv_passengers_val);
        TextView textBookingstatusVal = view.findViewById(R.id.tv_booking_status_val);
        TextView textCurrentstatusVal = view.findViewById(R.id.tv_current_status_val);

        TextView textTrainNameVal = view.findViewById(R.id.tv_train_name_val);
        TextView textJourneyclassVal = view.findViewById(R.id.tv_journey_class_val);
        TextView textReservationfromVal = view.findViewById(R.id.tv_reservation_from_val);
        TextView textReservationtoVal = view.findViewById(R.id.tv_reservation_to_val);
        TextView textBoardingpointVal = view.findViewById(R.id.tv_boarding_point_val);
        TextView texttDojVal = view.findViewById(R.id.tv_doj_val);
        TextView textChartpreparedVal = view.findViewById(R.id.tv_chart_prepared_val);




        textTrainNameVal.setText(model.getTrain().getName());
        textBoardingpointVal.setText(model.getBoardingPoint().getName());
        textJourneyclassVal.setText(model.getJourneyClass().getCode());
        textReservationfromVal.setText(model.getFromStation().getName());
        textReservationtoVal.setText(model.getToStation().getName());
        texttDojVal.setText(model.getDoj());

        if (model.getChartPrepared()) {
            textChartpreparedVal.setText("Chart prepared");
        } else textChartpreparedVal.setText("Chart not prepared");







        return view;
    }

}
