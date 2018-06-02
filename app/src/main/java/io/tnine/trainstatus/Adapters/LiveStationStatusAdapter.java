package io.tnine.trainstatus.Adapters;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.tnine.trainstatus.Models.ModelLiveStationStatus.LiveStationStatusModel;
import io.tnine.trainstatus.Models.ModelLiveStationStatus.LiveStationTrain;
import io.tnine.trainstatus.R;

public class LiveStationStatusAdapter extends RecyclerView.Adapter<LiveStationStatusAdapter.TrainArrivalsViewHolder> {

    Context context;
    LiveStationStatusModel model;
    List<LiveStationTrain> rvData;

    public LiveStationStatusAdapter(LiveStationStatusModel data, Context context) {
        this.context = context;
        model = data;
        rvData = model.getTrains();
    }

    @Override
    public TrainArrivalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_station_status_list_item, parent, false);
        TrainArrivalsViewHolder holder = new TrainArrivalsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TrainArrivalsViewHolder holder, int position) {
        holder.textTrainNumber.setText(rvData.get(position).getNumber());
        holder.textTrainName.setText(rvData.get(position).getName());
        holder.textActArrVal.setText(rvData.get(position).getActarr());
        holder.textActDepVal.setText(rvData.get(position).getActdep());
        holder.textSchArrVal.setText(rvData.get(position).getScharr());
        holder.textSchDepVal.setText(rvData.get(position).getSchdep());
        holder.textLateByVal.setText(rvData.get(position).getDelaydep());
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class TrainArrivalsViewHolder extends RecyclerView.ViewHolder {

        TextView textTrainNumber;
        TextView textTrainName;
        TextView textActArrVal;
        TextView textActDepVal;
        TextView textSchArrVal;
        TextView textSchDepVal;
        TextView textLateByVal;



        public TrainArrivalsViewHolder(View itemView) {
            super(itemView);
            textTrainName = itemView.findViewById(R.id.tv_train_name);
            textTrainNumber = itemView.findViewById(R.id.tv_train_number);
            textActArrVal = itemView.findViewById(R.id.tv_act_arr_val);
            textActDepVal = itemView.findViewById(R.id.tv_act_dep_val);
            textSchArrVal = itemView.findViewById(R.id.tv_sch_arr_val);
            textSchDepVal = itemView.findViewById(R.id.tv_sch_dep_val);
            textLateByVal = itemView.findViewById(R.id.tv_late_by_val);

        }
    }
}
