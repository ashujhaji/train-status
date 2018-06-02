package io.tnine.trainstatus.Fragments;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.tnine.trainstatus.Adapters.TrainAutoCompleteAdapter;
import io.tnine.trainstatus.Interfaces.ApiInterface;
import io.tnine.trainstatus.MainActivity;
import io.tnine.trainstatus.Models.ModelSeatAvailability.SeatAvailabilityModel;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrain;
import io.tnine.trainstatus.Models.ModelTrainRoute.TrainRouteModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.ApiClient;
import io.tnine.trainstatus.Utils.Config;
import io.tnine.trainstatus.Utils.DelayAutoCompleteTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeatAvailabilityDetailsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    ApiInterface apiInterface;
    private LiveTrain train;
    private String trainCode;
    private TrainRouteModel model;
    EditText editTextDate;
    Calendar c;
    SimpleDateFormat df;
    DatePickerDialog.OnDateSetListener mdate;
    List classCodes = new ArrayList<String>();
    List srcStations = new ArrayList<String>();
    List destStations = new ArrayList<String>();

    String[] quotaCodes;
    ArrayAdapter adapterSpinClass;
    ArrayAdapter adapterSpinSrc;
    ArrayAdapter adapterSpinDest;
    ArrayAdapter adapterSpinQuota;

    String src;
    String dest;

    String quota;
    String travelClass;
    ProgressDialog progressDoalog;

    public SeatAvailabilityDetailsFragment() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        quotaCodes = new String[]{"GENERAL", "TATKAL", "PREMIUM TATKAL"};
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_seat_availability_details, container, false);

        AppCompatSpinner spinnerSrc = view.findViewById(R.id.spin_train_source);
        AppCompatSpinner spinnerDest = view.findViewById(R.id.spin_train_dest);
        AppCompatSpinner spinnerClass = view.findViewById(R.id.spin_train_class);
        AppCompatSpinner spinnerQuota = view.findViewById(R.id.spin_train_quota);

        final DelayAutoCompleteTextView autoTrainCode = view.findViewById(R.id.acmtv_seat_train_code);
        editTextDate = view.findViewById(R.id.et_seat_pick_date);
        final Button btnGetseat = view.findViewById(R.id.btn_get_seat);
        Button btnCancelInputSeat = view.findViewById(R.id.btn_cancel_input_seat);



        c = Calendar.getInstance();
        df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());
        editTextDate.setText(formattedDate);

        mdate = new DatePickerDialog.OnDateSetListener() {

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

        autoTrainCode.setThreshold(2);
        autoTrainCode.setAdapter(new TrainAutoCompleteAdapter(getActivity()));
        autoTrainCode.setLoadingIndicator((android.widget.ProgressBar) view.findViewById(R.id.pb_loading_indicator_seat_train));



        adapterSpinClass = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, classCodes);
        adapterSpinSrc = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, srcStations);
        adapterSpinDest = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, destStations);
        adapterSpinQuota = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, quotaCodes);


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
                            if(response.body().getResponseCode() == 200) {
                                Log.e("seat Train Code Res", "Data loaded");
                                model = response.body();
                                Config.setTrainRouteModel(model);
                                for(int i = 0; i < Config.getTrainRouteModel().getTrain().getClasses().size(); i++){

                                    if (Config.getTrainRouteModel().getTrain().getClasses().get(i).getAvailable().equals("Y")) {
                                        classCodes.add(Config.getTrainRouteModel().getTrain().getClasses().get(i).getCode());
                                    }

                                }

                                adapterSpinClass.notifyDataSetChanged();

                                int s = Config.getTrainRouteModel().getRoute().size();
                                for (int i = 0; i < s; i++){

                                    srcStations.add(Config.getTrainRouteModel().getRoute().get(i).getStation().getName());
                                    destStations.add(Config.getTrainRouteModel().getRoute().get(s-(i+1)).getStation().getName());

                                }

                                adapterSpinSrc.notifyDataSetChanged();
                                adapterSpinDest.notifyDataSetChanged();

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<TrainRouteModel> call, Throwable t) {
                        Toast.makeText(getActivity(), "Request didn't go through", Toast.LENGTH_LONG).show();
                        Log.e("seat res failed", t.toString());
                    }
                });
            }
        });

        adapterSpinClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterSpinSrc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterSpinDest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterSpinQuota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerClass.setAdapter(adapterSpinClass);
        spinnerDest.setAdapter(adapterSpinDest);
        spinnerSrc.setAdapter(adapterSpinSrc);
        spinnerQuota.setAdapter(adapterSpinQuota);


        spinnerClass.setOnItemSelectedListener(this);

        spinnerQuota.setOnItemSelectedListener(this);
        spinnerDest.setOnItemSelectedListener(this);
        spinnerSrc.setOnItemSelectedListener(this);

        btnGetseat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                progressDoalog = new ProgressDialog(getActivity());
                progressDoalog.setCanceledOnTouchOutside(false);
                progressDoalog.setMessage("loading....");
                progressDoalog.setTitle("Fare Enquiry");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDoalog.show();

                Call<SeatAvailabilityModel> call = apiInterface.getSeatAvailability(trainCode,
                        src, dest, editTextDate.getText().toString(), travelClass, quota);
                call.enqueue(new Callback<SeatAvailabilityModel>() {
                    @Override
                    public void onResponse(Call<SeatAvailabilityModel> call, Response<SeatAvailabilityModel> response) {
                        if (response.isSuccessful()) {
                            Log.e("seat hit", "success");

                            if(response.body().getResponseCode() == 200){
                                Log.e("seat res", "data loaded");
                                progressDoalog.dismiss();
                                Config.setSeatAvailabilityModel(response.body());
                                Fragment seatAvailability = new SeatAvailability();
                                ((MainActivity)getActivity()).performTransaction(seatAvailability);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SeatAvailabilityModel> call, Throwable t) {
                        Log.e("seat res ", "failed");

                    }
                });
            }
        });

        btnCancelInputSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoTrainCode.setText("");
                srcStations.clear();
                destStations.clear();
                classCodes.clear();

                adapterSpinSrc.notifyDataSetChanged();
                adapterSpinDest.notifyDataSetChanged();
                adapterSpinClass.notifyDataSetChanged();
            }
        });



        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        int id = adapterView.getId();
        switch (id)
        {
            case R.id.spin_train_source:
                Log.e("spinner", "src");
                src = Config.getTrainRouteModel().getRoute().get(i).getStation().getCode();
                break;

            case R.id.spin_train_dest:
                Log.e("spinner", "dest");
                int size;
                size = Config.getTrainRouteModel().getRoute().size();
                dest = Config.getTrainRouteModel().getRoute().get(size - (i+1)).getStation().getCode();
                break;

            case R.id.spin_train_class:
                Log.e("spinner", "class");
                travelClass = (String) adapterSpinClass.getItem(i);
                break;

            case R.id.spin_train_quota:
                Log.e("spinner", "quota");
                if (i == 0) {
                    quota = "GN";
                } else if (i == 1) {
                    quota = "TQ";
                } else if (i == 2)
                    quota = "PT";
                break;


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
