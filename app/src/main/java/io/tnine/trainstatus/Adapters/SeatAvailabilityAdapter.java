package io.tnine.trainstatus.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.tnine.trainstatus.Fragments.SeatAvailability;
import io.tnine.trainstatus.Models.ModelSeatAvailability.Availability;
import io.tnine.trainstatus.Models.ModelSeatAvailability.SeatAvailabilityModel;
import io.tnine.trainstatus.R;

public class SeatAvailabilityAdapter extends RecyclerView.Adapter<SeatAvailabilityAdapter.SeatAvailabilityViewHolder> {
    Context context;
    SeatAvailabilityModel model;
    List<Availability> rvData;


    public SeatAvailabilityAdapter(Context context, SeatAvailabilityModel model) {
        this.context = context;
        this.model = model;
        rvData = model.getAvailability();
    }

    @Override
    public SeatAvailabilityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.availability_list_item, parent, false);

        SeatAvailabilityViewHolder holder = new SeatAvailabilityViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SeatAvailabilityViewHolder holder, int position) {

        holder.textDate.setText(rvData.get(position).getDate().toString());
        holder.textAvailability.setText(rvData.get(position).getStatus().toString());
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class SeatAvailabilityViewHolder extends RecyclerView.ViewHolder {

        TextView textDate;
        TextView textAvailability;

        public SeatAvailabilityViewHolder(View itemView) {
            super(itemView);
            textDate = itemView.findViewById(R.id.tv_availability_date);
            textAvailability = itemView.findViewById(R.id.tv_availability_val);
        }
    }
}
