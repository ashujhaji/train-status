package io.tnine.trainstatus.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.AndroidLogAdapter;

import io.tnine.trainstatus.Models.ModelTrainsBetweenStations.TrainsBetweenStations;
import io.tnine.trainstatus.Models.ModelTrainsBetweenStations.TrainsBetweenStationsModel;
import io.tnine.trainstatus.R;

/**
 * Created by nikun on 14-03-2018.
 */

public class TrainsBetweenStationsAdapter extends RecyclerView.Adapter<TrainsBetweenStationsAdapter.MyViewHolder> {

    private Context context;
    TrainsBetweenStationsModel mData;


    public TrainsBetweenStationsAdapter(TrainsBetweenStationsModel data, Context mContext) {
        this.context = mContext;
        this.mData = data;
        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trains_bw_stations_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TrainsBetweenStations model = mData.getTrains().get(position);

        holder.textTrainNumber.setText(model.getNumber());
        holder.textTrainName.setText(model.getName());
        holder.textTrainSource.setText(model.getFromStation().getName());
        holder.textTrainDest.setText(model.getToStation().getName());
        holder.textSrcStartTime.setText(model.getSrcDepartureTime());
        holder.textDestArrivalTime.setText(model.getDestArrivalTime());
        holder.textTravelTime.setText(model.getTravelTime());

        if (model.getDays().get(0).getRuns().equals("Y")) {
            holder.textRunsOnMonday.setVisibility(View.VISIBLE);
        } else holder.textRunsOnMonday.setEnabled(false);

        if (model.getDays().get(1).getRuns().equals("Y")) {
            holder.textRunsOnTuesday.setVisibility(View.VISIBLE);
        } else holder.textRunsOnTuesday.setEnabled(false);

        if (model.getDays().get(2).getRuns().equals("Y")) {
            holder.textRunsOnWednesday.setVisibility(View.VISIBLE);
        } else holder.textRunsOnWednesday.setEnabled(false);

        if (model.getDays().get(3).getRuns().equals("Y")) {
            holder.textRunsOnThursday.setVisibility(View.VISIBLE);
        } else holder.textRunsOnThursday.setEnabled(false);

        if (model.getDays().get(4).getRuns().equals("Y")) {
            holder.textRunsOnFriday.setVisibility(View.VISIBLE);
        } else holder.textRunsOnFriday.setEnabled(false);

        if (model.getDays().get(5).getRuns().equals("Y")) {
            holder.textRunsOnSaturday.setVisibility(View.VISIBLE);
        } else holder.textRunsOnSaturday.setEnabled(false);

        if (model.getDays().get(6).getRuns().equals("Y")) {
            holder.textRunsOnSunday.setVisibility(View.VISIBLE);
        } else holder.textRunsOnSunday.setEnabled(false);


    }

    @Override
    public int getItemCount() {
        return mData.getTrains().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textTrainNumber;
        TextView textTrainName;

        TextView textTrainSource;
        TextView textTrainDest;
        TextView textSrcStartTime;
        TextView textDestArrivalTime;
        TextView textTravelTime;
        TextView textRunsOnSunday;
        TextView textRunsOnMonday;
        TextView textRunsOnTuesday;
        TextView textRunsOnWednesday;
        TextView textRunsOnThursday;
        TextView textRunsOnFriday;
        TextView textRunsOnSaturday;


        public MyViewHolder(View itemView) {

            super(itemView);
            textTrainNumber = (TextView) itemView.findViewById(R.id.tv_trainnumber);
            textTrainName = (TextView) itemView.findViewById(R.id.tv_trainname);

            textTrainSource = (TextView) itemView.findViewById(R.id.tv_trainsource);
            textTrainDest = (TextView) itemView.findViewById(R.id.tv_traindest);
            textSrcStartTime = (TextView) itemView.findViewById(R.id.tv_starttime);
            textDestArrivalTime = (TextView) itemView.findViewById(R.id.tv_arrival_time);
            textTravelTime = (TextView) itemView.findViewById(R.id.tv_travel_time);
            textRunsOnSunday = (TextView) itemView.findViewById(R.id.tv_runs_on_sunday_label);
            textRunsOnMonday = (TextView) itemView.findViewById(R.id.tv_runs_on_monday_label);
            textRunsOnTuesday = (TextView) itemView.findViewById(R.id.tv_runs_on_tuesday_label);
            textRunsOnWednesday = (TextView) itemView.findViewById(R.id.tv_runs_on_wednesday_label);
            textRunsOnThursday = (TextView) itemView.findViewById(R.id.tv_runs_on_thursday_label);
            textRunsOnFriday = (TextView) itemView.findViewById(R.id.tv_runs_on_friday_label);
            textRunsOnSaturday = (TextView) itemView.findViewById(R.id.tv_runs_on_saturday_label);
        }
    }
}
