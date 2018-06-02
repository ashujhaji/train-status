package io.tnine.trainstatus.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.tnine.trainstatus.Adapters.TrainRouteAdapter;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;


public class TrainRouteFragment extends Fragment {

    private RecyclerView mCancelledTrains;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    public TrainRouteFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_train_route, container, false);

        RecyclerView recycleTrainStations = view.findViewById(R.id.rv_route_train_stations);
        TextView textTrainNumber = view.findViewById(R.id.tv_route_train_number);
        TextView textTrainName = view.findViewById(R.id.tv_route_train_name);
        TextView textRunsOnSunday = view.findViewById(R.id.tv_route_runs_sun);
        TextView textRunsOnMonday = view.findViewById(R.id.tv_route_runs_mon);
        TextView textRunsOnTuesday = view.findViewById(R.id.tv_route_runs_tue);
        TextView textRunsOnWednesday = view.findViewById(R.id.tv_route_runs_wed);
        TextView textRunsOnThursday = view.findViewById(R.id.tv_route_runs_thu);
        TextView textRunsOnFriday = view.findViewById(R.id.tv_route_runs_fri);
        TextView textRunsOnSaturday = view.findViewById(R.id.tv_route_runs_sat);


        textTrainNumber.setText(Config.getTrainRouteModel().getTrain().getNumber());
        textTrainName.setText(Config.getTrainRouteModel().getTrain().getName());
        if(Config.getTrainRouteModel().getTrain().getDays().get(0).getRuns().equals("N"))
            textRunsOnMonday.setEnabled(false);

        if(Config.getTrainRouteModel().getTrain().getDays().get(1).getRuns().equals("N"))
            textRunsOnTuesday.setEnabled(false);

        if(Config.getTrainRouteModel().getTrain().getDays().get(2).getRuns().equals("N"))
            textRunsOnWednesday.setEnabled(false);

        if(Config.getTrainRouteModel().getTrain().getDays().get(3).getRuns().equals("N"))
            textRunsOnThursday.setEnabled(false);

        if(Config.getTrainRouteModel().getTrain().getDays().get(4).getRuns().equals("N"))
            textRunsOnFriday.setEnabled(false);

        if(Config.getTrainRouteModel().getTrain().getDays().get(5).getRuns().equals("N"))
            textRunsOnSaturday.setEnabled(false);

        if(Config.getTrainRouteModel().getTrain().getDays().get(6).getRuns().equals("N"))
            textRunsOnSunday.setEnabled(false);



        mAdapter = new TrainRouteAdapter(getActivity(), Config.getTrainRouteModel());
        recycleTrainStations.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getActivity());
        recycleTrainStations.setLayoutManager(mlayoutManager);
        recycleTrainStations.setAdapter(mAdapter);

















        return view;
    }

}
