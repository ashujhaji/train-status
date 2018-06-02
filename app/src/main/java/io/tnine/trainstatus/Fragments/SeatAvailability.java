package io.tnine.trainstatus.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.tnine.trainstatus.Adapters.SeatAvailabilityAdapter;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;


public class SeatAvailability extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    public SeatAvailability() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_seat_availability, container, false);

        TextView textSeatClass = view.findViewById(R.id.tv_seat_class_val);
        RecyclerView recycleAvailability = view.findViewById(R.id.rv_availability);



        textSeatClass.setText(Config.getSeatAvailabilityModel().getJourneyClass().getCode().toString());


        mAdapter = new SeatAvailabilityAdapter(getActivity(), Config.getSeatAvailabilityModel());
        recycleAvailability.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getActivity());
        recycleAvailability.setLayoutManager(mlayoutManager);
        recycleAvailability.setAdapter(mAdapter);















        return view;
    }

}
