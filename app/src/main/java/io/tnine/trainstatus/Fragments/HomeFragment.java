package io.tnine.trainstatus.Fragments;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.tnine.trainstatus.Adapters.StationAutoCompleteAdapter;
import io.tnine.trainstatus.MainActivity;
import io.tnine.trainstatus.Models.ModelCancelledTrains.CancelledTrainsModel;
import io.tnine.trainstatus.Models.ModelRescheduledTrains.RescheduledTrainsModel;
import io.tnine.trainstatus.Utils.ApiClient;
import io.tnine.trainstatus.Utils.Config;
import io.tnine.trainstatus.Utils.DelayAutoCompleteTextView;
import io.tnine.trainstatus.Interfaces.ApiInterface;
import io.tnine.trainstatus.Models.Station;
import io.tnine.trainstatus.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentTransaction ft;
    private Fragment cancelledTrains = new CancelledTrains();
    ApiInterface apiInterface;
    private Boolean trainsEnabledState = false;
    private Boolean ifFromStationEntered = false;
    private Boolean ifToStationEntered = false;
    ProgressDialog progressDialog;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    public HomeFragment() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final Button btnGetTrainsBetweenStations = (Button) view.findViewById(R.id.btn_get_trains_bw_stations);
        Button btnLiveTrain = (Button) view.findViewById(R.id.btn_live_train);
        final Button btnRescheduledTrain = (Button) view.findViewById(R.id.btn_rescheduled);
        final EditText editTextDate = (EditText) view.findViewById(R.id.et_pick_dat);
        final DelayAutoCompleteTextView autoTo = (DelayAutoCompleteTextView) view.findViewById(R.id.acmtv_to);
        final DelayAutoCompleteTextView autoFrom = (DelayAutoCompleteTextView) view.findViewById(R.id.acmtv_from);
        Button btnCancelledTrains = (Button) view.findViewById(R.id.btn_cancelled);
        Button btnPnrStatus = view.findViewById(R.id.btn_pnr);
        Button btnTrainSchedule = view.findViewById(R.id.btn_train_schedule);
        Button btnLiveStationStatus = view.findViewById(R.id.btn_live_station);
        Button btnSeatAvailability = view.findViewById(R.id.btn_seat_availability);
        Button btnFareEnquiry = view.findViewById(R.id.btn_fair_enquiry);
        Button btnCancelInputFrom = view.findViewById(R.id.btn_cancel_input_from);
        Button btnCancelInputTo = view.findViewById(R.id.btn_cancel_input_to);


        btnGetTrainsBetweenStations.setEnabled(trainsEnabledState);

        final Calendar c = Calendar.getInstance();
        final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        editTextDate.setText(formattedDate);

        final DatePickerDialog.OnDateSetListener mdate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, monthOfYear);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                editTextDate.setText(df.format(c.getTime()));
            }

        };

        editTextDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(getActivity(), mdate, c
                        .get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        autoTo.setThreshold(2);
        autoFrom.setThreshold(2);

        autoTo.setAdapter(new StationAutoCompleteAdapter(getActivity()));
        autoFrom.setAdapter(new StationAutoCompleteAdapter(getActivity()));

        autoFrom.setLoadingIndicator((android.widget.ProgressBar) view.findViewById(R.id.pb_loading_indicator_from));
        autoTo.setLoadingIndicator((android.widget.ProgressBar) view.findViewById(R.id.pb_loading_indicator_to));

        autoFrom.setOnItemClickListener(new AdapterView.OnItemClickListener() {                     //From Station AutoCompleteTextView
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Station station = (Station) adapterView.getItemAtPosition(position);
                autoFrom.setText(station.getName()+" - "+station.getCode());
                ifFromStationEntered = true;
                if(ifFromStationEntered == true && ifToStationEntered == true){
                    trainsEnabledState = true;
                    Log.e("button state", trainsEnabledState.toString());

                }
            }
        });

        autoTo.setOnItemClickListener(new AdapterView.OnItemClickListener() {                       //To Station AutoCompleteTextView
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Station station = (Station) adapterView.getItemAtPosition(position);
                autoTo.setText(station.getName()+" - "+station.getCode());
                ifToStationEntered = true;
                if(ifFromStationEntered == true && ifToStationEntered == true){
                    trainsEnabledState = true;
                    btnGetTrainsBetweenStations.setEnabled(trainsEnabledState);
                    Log.e("button state", trainsEnabledState.toString());

                }
            }
        });



        //TODO: set a common OnClickListener for all buttons
        Call<CancelledTrainsModel> call = apiInterface.getCancelledTrains(formattedDate, Config.myApiKey);
        call.enqueue(new Callback<CancelledTrainsModel>() {
            @Override
            public void onResponse(Call<CancelledTrainsModel> call, Response<CancelledTrainsModel> response) {
                    if (response.isSuccessful()) {
                    if (response.body().getResponseCode() == 200) {
                        Config.setCancelledTrainsModel(response.body());
                    }
                }
            }
            @Override
            public void onFailure(Call<CancelledTrainsModel> call, Throwable t) {
                Log.e("CancelTrain res fail", t.toString());
            }
        });

        Call <RescheduledTrainsModel> callReschTrains = apiInterface.getRescheduledTrains(formattedDate);
        callReschTrains.enqueue(new Callback<RescheduledTrainsModel>() {
            @Override
            public void onResponse(Call<RescheduledTrainsModel> callReschTrains, Response<RescheduledTrainsModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getResponseCode() == 200) {
                        Config.setRescheduledTrainsModel(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<RescheduledTrainsModel> callReschTrains, Throwable t) {
                Log.e("Resch. Trains Res. fail", t.toString());
            }
        });

        btnCancelledTrains.setOnClickListener(new View.OnClickListener() {                          //Cancelled Trains Button
            @Override
            public void onClick(View view) {
                Fragment cancelledTrains = new CancelledTrains();
                ((MainActivity)getActivity()).performTransaction(cancelledTrains);


            }
        });

        btnGetTrainsBetweenStations.setOnClickListener(new View.OnClickListener() {                 //Trains Between Stations Button
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setMessage("loading....");
                progressDialog.setTitle("Fare Enquiry");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                progressDialog.show();


                String fromAutoCompleteTextViewText = autoFrom.getText().toString();
                String toAutoCompleteTextViewText = autoTo.getText().toString();
                String dateChosen = editTextDate.getText().toString();
                Log.d("Test",dateChosen);

                String substrFrom = fromAutoCompleteTextViewText.substring(fromAutoCompleteTextViewText.lastIndexOf("-") + 2);
                String substrTo = toAutoCompleteTextViewText.substring(toAutoCompleteTextViewText.lastIndexOf("-") + 2);

                Bundle bundle = new Bundle();
                bundle.putString("src_stn_code", substrFrom);
                bundle.putString("dest_stn_code", substrTo);
                bundle.putString("trains_bw_date", dateChosen);

                Fragment trainsbwStations = new TrainsBetweenStationsFragment();
                trainsbwStations.setArguments(bundle);

                ((MainActivity)getActivity()).performTransaction(trainsbwStations);


            }
        });


        btnLiveTrain.setOnClickListener(new View.OnClickListener() {                                //Live Train Status button
            @Override
            public void onClick(View view) {

                Fragment liveTrain = new LiveTrainFragment();
                ((MainActivity)getActivity()).performTransaction(liveTrain);


            }
        });

        btnRescheduledTrain.setOnClickListener(new View.OnClickListener() {                         //Rescheduled Trains button
            @Override
            public void onClick(View view) {
                Fragment rescheduledTrain = new RescheduledTrainsFragment();
                ((MainActivity)getActivity()).performTransaction(rescheduledTrain);
            }
        });

        btnTrainSchedule.setOnClickListener(new View.OnClickListener() {                            //Train Schedule Button
            @Override
            public void onClick(View view) {
                Fragment trainRoute = new TrainRouteDetailsFragment();
                ((MainActivity)getActivity()).performTransaction(trainRoute);
            }
        });

        btnLiveStationStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment liveStationStatus = new LiveStationFragment();
                ((MainActivity)getActivity()).performTransaction(liveStationStatus);
            }
        });

        btnPnrStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment pnrDetails = new PnrDetailsFragment();
                ((MainActivity)getActivity()).performTransaction(pnrDetails);

            }
        });

        btnSeatAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment seatAvailabilityDetailsFragment = new SeatAvailabilityDetailsFragment();
                ((MainActivity)getActivity()).performTransaction(seatAvailabilityDetailsFragment);

            }
        });

        btnFareEnquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fareDetailsFragment = new FareDetailsFragment();
                ((MainActivity)getActivity()).performTransaction(fareDetailsFragment);

            }
        });

        btnCancelInputFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autoFrom.setText("");
                btnGetTrainsBetweenStations.setEnabled(false);
            }
        });

        btnCancelInputTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autoTo.setText("");
                btnGetTrainsBetweenStations.setEnabled(false);

            }
        });




        return view;
    }

}
