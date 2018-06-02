package io.tnine.trainstatus.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.tnine.trainstatus.Adapters.LiveTrainStatusAdapter;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrainStatusModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;


/**
 * A simple {@link Fragment} subclass.
 */
public class LiveStatusTrain extends Fragment {

    private RecyclerView liveTrainStatusRoutes;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private LiveTrainStatusModel mData;

    public LiveStatusTrain() {
        mData = Config.getLiveTrainStatusModel(); // Required empty public constructor
        //Log.e("data when buton pressed", mData.getTrain().getName());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.live_status_train, container, false);

        liveTrainStatusRoutes = (RecyclerView) view.findViewById(R.id.rv_live_train);
        TextView textCurrentStation = view.findViewById(R.id.tv_current_station);
        TextView textDate = view.findViewById(R.id.tv_date);


        textCurrentStation.setText(Config.getLiveTrainStatusModel().getPosition());
        textDate.setText(Config.getLiveTrainStatusModel().getStartDate());


        mAdapter = new LiveTrainStatusAdapter(mData, getActivity());
        liveTrainStatusRoutes.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getActivity());
        liveTrainStatusRoutes.setLayoutManager(mlayoutManager);
        liveTrainStatusRoutes.setAdapter(mAdapter);

        return view;
    }

}
