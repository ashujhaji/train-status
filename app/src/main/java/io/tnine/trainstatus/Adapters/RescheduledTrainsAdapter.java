package io.tnine.trainstatus.Adapters;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.tnine.trainstatus.Models.ModelRescheduledTrains.RescheduledTrain;
import io.tnine.trainstatus.Models.ModelRescheduledTrains.RescheduledTrainsModel;
import io.tnine.trainstatus.R;

public class RescheduledTrainsAdapter extends RecyclerView.Adapter<RescheduledTrainsAdapter.RescheduledTrainViewHolder> {

    Context context;
    RescheduledTrainsModel model;
    List<RescheduledTrain> rvData;

    public RescheduledTrainsAdapter(Context context, RescheduledTrainsModel model) {
        this.context = context;
        this.model = model;
        rvData = model.getTrains();
    }

    @Override
    public RescheduledTrainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rescheduled_trains_list_item, parent, false);
        RescheduledTrainViewHolder holder = new RescheduledTrainViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RescheduledTrainViewHolder holder, int position) {
        holder.textTrainNumber.setText(rvData.get(position).getNumber());
        holder.textTrainName.setText(rvData.get(position).getName());
        holder.textFromStation.setText(rvData.get(position).getFromStation().getName());
        holder.textToStation.setText(rvData.get(position).getToStation().getName());
        holder.textReschTimeVal.setText(rvData.get(position).getRescheduledTime());
        holder.textReschDateVal.setText(rvData.get(position).getRescheduledDate());

        //TODO: perform actual train time calculation

    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class RescheduledTrainViewHolder extends RecyclerView.ViewHolder {

        TextView textTrainNumber;
        TextView textTrainName;
        TextView textFromStation;
        TextView textToStation;
        TextView textActTimeVal;
        TextView textReschTimeVal;
        TextView textReschDateVal;


        public RescheduledTrainViewHolder(View itemView) {
            super(itemView);
            textTrainNumber = itemView.findViewById(R.id.tv_train_number);
            textTrainName = itemView.findViewById(R.id.tv_train_name);
            textFromStation = itemView.findViewById(R.id.tv_from_station);
            textToStation = itemView.findViewById(R.id.tv_to_station);
            textActTimeVal = itemView.findViewById(R.id.tv_actual_time_val);
            textReschTimeVal = itemView.findViewById(R.id.tv_rescheduled_time_val);
            textReschDateVal = itemView.findViewById(R.id.tv_rescheduled_date_val);
        }
    }
}
