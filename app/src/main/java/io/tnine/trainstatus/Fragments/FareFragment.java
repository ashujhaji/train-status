package io.tnine.trainstatus.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.tnine.trainstatus.Models.ModelFareEnquiry.FareEnquiryModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;


public class FareFragment extends Fragment {

    FareEnquiryModel fareModel;

    public FareFragment() {

        fareModel = Config.getFareEnquiryModel();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fare, container, false);
        TextView textClassCodeVal = view.findViewById(R.id.tv_fare_class_val);
        TextView textFareVal = view.findViewById(R.id.tv_fare_val);
        TextView textBaseFareVal = view.findViewById(R.id.tv_base_fare_val);
        TextView textResvChargeVal = view.findViewById(R.id.tv_resv_charge_val);
        TextView textSuperfastChargeVal = view.findViewById(R.id.tv_superfast_charges_val);
        TextView textOtherChargeVal = view.findViewById(R.id.tv_superfast_charges_val);
        TextView textGstChargeVal = view.findViewById(R.id.tv_gst_charge_val);
        TextView textTotalAmount = view.findViewById(R.id.tv_total_fare_val);

        textClassCodeVal.setText(fareModel.getJourneyClass().getCode().toString());
        textFareVal.setText(fareModel.getFare().toString());
        textTotalAmount.setText(fareModel.getFare().toString());














        return view;
    }

}
