package io.tnine.trainstatus.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.tnine.trainstatus.Models.ModelTrainRoute.Route;
import io.tnine.trainstatus.Models.ModelTrainRoute.TrainRouteModel;
import io.tnine.trainstatus.R;
import io.tnine.trainstatus.Utils.Config;

public class TrainRouteAdapter extends RecyclerView.Adapter<TrainRouteAdapter.TrainRouteViewHolder> {
    Context context;
    TrainRouteModel model;
    List<Route> rvData;



    public TrainRouteAdapter(Context context, TrainRouteModel model) {
        this.context = context;
        this.model = model;
        rvData = model.getRoute();
    }

    @Override
    public TrainRouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.train_route_station_list_item, parent, false);
        TrainRouteViewHolder holder = new TrainRouteViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TrainRouteViewHolder holder, int position) {
        holder.textSerialNumber.setText(rvData.get(position).getNo().toString());
        holder.textStationName.setText(rvData.get(position).getStation().getCode() + " - " + rvData.get(position).getStation().getName());
        holder.textArrivalTimeVal.setText(rvData.get(position).getScharr());
        holder.textDepartureTimeVal.setText(rvData.get(position).getSchdep());
        holder.textDistance.setText(rvData.get(position).getDistance().toString());
        holder.textDays.setText(rvData.get(position).getDay().toString());

    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class TrainRouteViewHolder extends RecyclerView.ViewHolder {

        TextView textSerialNumber;
        TextView textStationName;
        TextView textArrivalTimeVal;
        TextView textDepartureTimeVal;
        TextView textDistance;
        TextView textDays;



        public TrainRouteViewHolder(View itemView) {
            super(itemView);
            textSerialNumber = itemView.findViewById(R.id.tv_route_serial_no_val);
            textStationName = itemView.findViewById(R.id.tv_route_station_val);
            textArrivalTimeVal = itemView.findViewById(R.id.tv_route_arrival_time_val);
            textDepartureTimeVal = itemView.findViewById(R.id.tv_route_dep_time_val);
            textDistance = itemView.findViewById(R.id.tv_route_distance_val);
            textDays = itemView.findViewById(R.id.tv_route_day_val);
        }
    }
}
