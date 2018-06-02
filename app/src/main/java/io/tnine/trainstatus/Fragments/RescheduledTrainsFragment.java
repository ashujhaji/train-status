package io.tnine.trainstatus.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.tnine.trainstatus.Adapters.RescheduledTrainsAdapter;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;

public class RescheduledTrainsFragment extends Fragment {

    private RecyclerView mRescheduledTrains;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;


    public RescheduledTrainsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rescheduled_trains, container, false);

        RecyclerView recycleReschTrains = view.findViewById(R.id.rv_rescheduled_trains);


        mAdapter = new RescheduledTrainsAdapter(getActivity(), Config.getRescheduledTrainsModel());
        recycleReschTrains.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getActivity());
        recycleReschTrains.setLayoutManager(mlayoutManager);
        recycleReschTrains.setAdapter(mAdapter);






        return view;
    }

}
