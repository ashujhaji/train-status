package io.tnine.trainstatus.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import io.tnine.trainstatus.Adapters.StationAutoCompleteAdapter;
import io.tnine.trainstatus.Interfaces.ApiInterface;
import io.tnine.trainstatus.MainActivity;
import io.tnine.trainstatus.Models.ModelLiveStationStatus.LiveStationStatusModel;
import io.tnine.trainstatus.Models.Station;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.ApiClient;
import io.tnine.trainstatus.Utils.Config;
import io.tnine.trainstatus.Utils.DelayAutoCompleteTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LiveStationFragment extends Fragment {
    ApiInterface apiInterface;

    public LiveStationFragment() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_live_station, container, false);

        final DelayAutoCompleteTextView autoStation = view.findViewById(R.id.acmtv_live_station_code);
        final Button btnGetTrainArrivals = view.findViewById(R.id.btn_get_train_arrivals);
        Button btnCancelInputLiveStation = view.findViewById(R.id.btn_cancel_input_live_station);


        autoStation.setText("");
        btnGetTrainArrivals.setEnabled(false);
        autoStation.setThreshold(3);
        autoStation.setAdapter(new StationAutoCompleteAdapter(getActivity()));
        autoStation.setLoadingIndicator((android.widget.ProgressBar) view.findViewById(R.id.pb_loading_indicator_live_station));
        autoStation.setOnItemClickListener(new AdapterView.OnItemClickListener() {                     //From Station AutoCompleteTextView
                                               @Override
                                               public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                                   Station station = (Station) adapterView.getItemAtPosition(position);
                                                   autoStation.setText(station.getName() + " - " + station.getCode());
                                                   Call<LiveStationStatusModel> call = apiInterface.getTrainArrivals(station.getCode(), "4");
                                                   call.enqueue(new Callback<LiveStationStatusModel>() {
                                                       @Override
                                                       public void onResponse(Call<LiveStationStatusModel> call, Response<LiveStationStatusModel> response) {
                                                           if (response.isSuccessful()){
                                                               if(response.body().getResponseCode() == 200){
                                                                   Config.setLiveStationStatusModel(response.body());
                                                                   btnGetTrainArrivals.setEnabled(true);
                                                               }
                                                           }

                                                       }

                                                       @Override
                                                       public void onFailure(Call<LiveStationStatusModel> call, Throwable t) {
                                                           Log.e("Exception Live station", t.toString());

                                                       }


                                                   });
                                               }
                                           });

        btnGetTrainArrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fromAutoCompleteTextViewText = autoStation.getText().toString();
                String substrStation = fromAutoCompleteTextViewText.substring(fromAutoCompleteTextViewText.lastIndexOf("-") + 2);
                Bundle bundle = new Bundle();
                bundle.putString("stn_code", substrStation);

                Fragment liveStationStatus = new LiveStationStatusFragment();
                liveStationStatus.setArguments(bundle);

                ((MainActivity)getActivity()).performTransaction(liveStationStatus);
            }
        });

        btnCancelInputLiveStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoStation.setText("");
                btnGetTrainArrivals.setEnabled(false);
            }
        });












        return view;
    }

}
