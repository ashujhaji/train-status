package io.tnine.trainstatus.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.tnine.trainstatus.Utils.ApiClient;
import io.tnine.trainstatus.Interfaces.ApiInterface;
import io.tnine.trainstatus.Models.Station;
import io.tnine.trainstatus.Models.StationAutoCompleteSuggestions.StationAutoCompleteSuggest;
import io.tnine.trainstatus.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nikun on 12-03-2018.
 */

public class StationAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;
    private Context mContext;
    private List<Station> resultList = new ArrayList<Station>();

    public StationAutoCompleteAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Object getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.suggestions_list_item, parent, false);
        }
        //Log.e("testdata", resultList.get(0).getName().toString());
        ((TextView) view.findViewById(R.id.text1)).setText(resultList.get(position).getName());
        ((TextView) view.findViewById(R.id.text2)).setText(resultList.get(position).getCode());
        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            List<Station> stationSuggestions;
            @Override
            protected FilterResults performFiltering(final CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0){
                    stationSuggestions = null;
                }
                if (constraint != null && constraint.length() > 0) {

                    final ApiInterface apiInterface;
                    apiInterface = ApiClient.getClient().create(ApiInterface.class);
                    final Call<StationAutoCompleteSuggest> codeCall = apiInterface.getStationsFromCode(constraint);
                    codeCall.enqueue(new Callback<StationAutoCompleteSuggest>() {
                        @Override
                        public void onResponse(Call<StationAutoCompleteSuggest> call, Response<StationAutoCompleteSuggest> response) {

                            if (response.isSuccessful()) {
                                Log.e("Request hit", "is successful");

                                if (response.body().getResponseCode() == 200 && response.body().getStations().size() > 0) {
                                    Log.e("List is", "Not null");
                                    stationSuggestions = response.body().getStations();

                                }

                                else if (response.body().getResponseCode() == 200 && response.body().getStations().size() == 0){
                                    Log.e("List is", "null");
                                    codeCall.cancel();

                                    Call<StationAutoCompleteSuggest> nameCall = apiInterface.getStationSuggestions(constraint);
                                    nameCall.enqueue(new Callback<StationAutoCompleteSuggest>() {
                                        @Override
                                        public void onResponse(Call<StationAutoCompleteSuggest> call, Response<StationAutoCompleteSuggest> response) {
                                            if (response.isSuccessful()) {
                                                Log.e("Request hit: stn[] null", "is successful");

                                                if (response.body().getResponseCode() == 200) {
                                                    stationSuggestions = response.body().getStations();

                                                }
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<StationAutoCompleteSuggest> call, Throwable t) {
                                            Log.e("Exception", t.toString());
                                        }
                                    });

                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<StationAutoCompleteSuggest> call, Throwable t) {

                        }
                    });

                    //Log.e("Data from autotext", constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = stationSuggestions;
                    filterResults.count = stationSuggestions.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {

                    resultList = (List<Station>) results.values;
                    //Log.e("resultlist", resultList.get(0).getName());
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }
}
