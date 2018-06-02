package io.tnine.trainstatus.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.tnine.trainstatus.Adapters.CancelledTrainsAdapter;
import io.tnine.trainstatus.Utils.ApiClient;
import io.tnine.trainstatus.Interfaces.ApiInterface;
import io.tnine.trainstatus.Models.ModelCancelledTrains.CancelledTrainsModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CancelledTrains extends Fragment {

    private RecyclerView mCancelledTrains;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private ApiInterface apiInterface;

    public CancelledTrains() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cancelled_trains, container, false);

        mCancelledTrains = (RecyclerView) view.findViewById(R.id.rv_cancelledtrains);



        mAdapter = new CancelledTrainsAdapter(Config.getCancelledTrainsModel(), getActivity());
        mCancelledTrains.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getActivity());
        mCancelledTrains.setLayoutManager(mlayoutManager);
        mCancelledTrains.setAdapter(mAdapter);


        return view;

    }

}
