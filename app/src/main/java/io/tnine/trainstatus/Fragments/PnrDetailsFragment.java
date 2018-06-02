package io.tnine.trainstatus.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.tnine.trainstatus.Interfaces.ApiInterface;
import io.tnine.trainstatus.MainActivity;
import io.tnine.trainstatus.Models.ModelPnrStatus.PnrStatusModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.ApiClient;
import io.tnine.trainstatus.Utils.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PnrDetailsFragment extends Fragment {

    ApiInterface apiInterface;


    public PnrDetailsFragment() {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pnr_details, container, false);
        TextInputLayout textInput = view.findViewById(R.id.ti_pnr);
        final Button btnGetPnrStatus = view.findViewById(R.id.btn_get_pnr_status);
        final EditText editPnrNumber = view.findViewById(R.id.et_pnr_number);
        Button btnCancelInputPnr = view.findViewById(R.id.btn_cancel_input_pnr);



        btnGetPnrStatus.setEnabled(false);





        editPnrNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    if (editPnrNumber.getText().length() == 10) {
                        InputMethodManager imm = (InputMethodManager) ((MainActivity)getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                        Call <PnrStatusModel> call = apiInterface.getPnrStatus(editPnrNumber.getText().toString());
                        call.enqueue(new Callback<PnrStatusModel>() {
                            @Override
                            public void onResponse(Call<PnrStatusModel> call, Response<PnrStatusModel> response) {
                                if (response.isSuccessful()) {
                                    Log.e("Request hit", "is successful");

                                    if (response.body().getResponseCode() == 200) {
                                        Log.e("PNR Response", response.body().getResponseCode() + "");
                                        btnGetPnrStatus.setEnabled(true);
                                        Config.setPnrStatusModel(response.body());
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<PnrStatusModel> call, Throwable t) {
                                Log.e("PNR response failure", t.toString());
                            }
                        });
                    }

                    return true;
                }
                return false;
            }

        });


        btnGetPnrStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment pnrStatus = new PnrStatusFragment();
                ((MainActivity)getActivity()).performTransaction(pnrStatus);
            }
        });

        btnCancelInputPnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPnrNumber.setText("");
                btnGetPnrStatus.setEnabled(false);
            }
        });



        return view;
    }

}
