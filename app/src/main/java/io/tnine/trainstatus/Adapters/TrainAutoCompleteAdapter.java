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
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrain;
import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrainsModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nikun on 16-03-2018.
 */

public class TrainAutoCompleteAdapter extends BaseAdapter implements Filterable {
    private static final int MAX_RESULTS = 10;
    private Context mContext;
    private List<LiveTrain> resultList = new ArrayList<LiveTrain>();

    public TrainAutoCompleteAdapter(Context context) {
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
        ((TextView) view.findViewById(R.id.text1)).setText(resultList.get(position).getNumber());
        ((TextView) view.findViewById(R.id.text2)).setText(resultList.get(position).getName());
        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            List<LiveTrain> trainSuggestions;
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0){
                    trainSuggestions = null;
                }
                if (constraint != null && constraint.length() > 0) {

                    ApiInterface apiInterface;
                    apiInterface = ApiClient.getClient().create(ApiInterface.class);
                    Log.e("Constraint", constraint.toString() + " | Decision: " +Config.isDecision());
                    if(Config.isDecision() == true){
                        Call<LiveTrainsModel> call = apiInterface.getTrainSuggestions(constraint.toString());
                        call.enqueue(new Callback<LiveTrainsModel>() {
                            @Override
                            public void onResponse(Call<LiveTrainsModel> call, Response<LiveTrainsModel> response) {
                                LiveTrainsModel suggest = response.body();
                                Log.e("Hello from response", suggest.getResponseCode().toString());
                                try{
                                    if(suggest != null) {
                                        trainSuggestions = suggest.getTrains();
                                    }
                                } catch (NullPointerException e){
                                    Log.e("Exception at adapter", e.toString());
                                }
                                //Log.e("train name", stationSuggestions.get(0).getName().toString());



                            }



                            @Override
                            public void onFailure(Call<LiveTrainsModel> call, Throwable t) {
                                Log.e("Response failed suggest", t.toString());
                            }
                        });


                    }

                    //Log.e("Data from autotext", constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = trainSuggestions;
                    filterResults.count = trainSuggestions.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {

                    resultList = (List<LiveTrain>) results.values;
                    //Log.e("resultlist", resultList.get(0).getName());
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }
}
