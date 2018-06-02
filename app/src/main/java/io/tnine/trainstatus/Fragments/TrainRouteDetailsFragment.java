package io.tnine.trainstatus.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import io.tnine.trainstatus.Adapters.TrainAutoCompleteAdapter;
import io.tnine.trainstatus.Interfaces.ApiInterface;
import io.tnine.trainstatus.MainActivity;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrain;
import io.tnine.trainstatus.Models.ModelTrainRoute.TrainRouteModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.ApiClient;
import io.tnine.trainstatus.Utils.Config;
import io.tnine.trainstatus.Utils.DelayAutoCompleteTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrainRouteDetailsFragment extends Fragment {
    ApiInterface apiInterface;
    private LiveTrain train;
    private String trainCode;
    private TrainRouteModel model;

    public TrainRouteDetailsFragment() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_train_route_details, container, false);

        final Button btnGetTrainRoute = view.findViewById(R.id.btn_get_train_route);
        Button btnCancelInputRoute = view.findViewById(R.id.btn_cancel_input_route);
        final DelayAutoCompleteTextView autoTrainCode = view.findViewById(R.id.acmtv_route_train_code);

        btnGetTrainRoute.setEnabled(false);

        autoTrainCode.setThreshold(3);
        autoTrainCode.setAdapter(new TrainAutoCompleteAdapter(getActivity()));
        autoTrainCode.setLoadingIndicator((android.widget.ProgressBar) view.findViewById(R.id.pb_loading_indicator_live_train));
        autoTrainCode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                train = (LiveTrain) adapterView.getItemAtPosition(position);
                autoTrainCode.setText(train.getNumber()+" - "+train.getName());
                trainCode = train.getNumber();
                Call<TrainRouteModel> call = apiInterface.getTrainRoute(trainCode);
                call.enqueue(new Callback<TrainRouteModel>() {
                    @Override
                    public void onResponse(Call<TrainRouteModel> call, Response<TrainRouteModel> response) {
                        if(response.isSuccessful()) {
                            Log.e("Request hit", "is successful");

                            if(response.body().getResponseCode() == 200) {
                                Log.e("Train Route Response", "200");
                                model = response.body();
                                btnGetTrainRoute.setEnabled(true);
                                Config.setTrainRouteModel(model);
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<TrainRouteModel> call, Throwable t) {
                        Log.e("Train route res failure", t.toString());
                    }
                });
            }
        });

        btnGetTrainRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment trainRoute = new TrainRouteFragment();
                ((MainActivity)getActivity()).performTransaction(trainRoute);
            }
        });

        btnCancelInputRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoTrainCode.setText("");
                btnGetTrainRoute.setEnabled(false);
            }
        });




        return view;
    }

}
