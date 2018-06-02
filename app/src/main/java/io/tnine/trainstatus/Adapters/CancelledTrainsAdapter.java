package io.tnine.trainstatus.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.tnine.trainstatus.Fragments.CancelledTrains;
import io.tnine.trainstatus.Models.ModelCancelledTrains.CancelledTrainsModel;
import io.tnine.trainstatus.Models.Train;
import io.tnine.trainstatus.R;

/**
 * Created by nikun on 10-03-2018.
 */

public class CancelledTrainsAdapter extends RecyclerView.Adapter<CancelledTrainsAdapter.MyViewHolder> {

    Context context;
    CancelledTrainsModel mData;
    List<Train> rvData;

    public CancelledTrainsAdapter(CancelledTrainsModel data, Context mContext) {
        this.context = mContext;
        this.mData = data;
        rvData = mData.getTrains();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cancelled_trains_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textTrainNumber.setText(rvData.get(position).getNumber());
        holder.textTrainName.setText(rvData.get(position).getName());
        holder.textTrainType.setText(rvData.get(position).getType());
        holder.textTrainSource.setText(rvData.get(position).getSource().getName());
        holder.textTrainDest.setText(rvData.get(position).getDest().getName());
        holder.textStartTime.setText(rvData.get(position).getStartTime());



    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textTrainNumber;
        TextView textTrainName;
        TextView textTrainType;
        TextView textTrainSource;
        TextView textTrainDest;
        TextView textStartTime;





        public MyViewHolder(View itemView) {
            super(itemView);
            textTrainNumber = (TextView) itemView.findViewById(R.id.tv_trainnumber);
            textTrainName = (TextView) itemView.findViewById(R.id.tv_trainname);
            textTrainType = (TextView) itemView.findViewById(R.id.tv_train_type);
            textTrainSource = (TextView) itemView.findViewById(R.id.tv_trainsource);
            textTrainDest = (TextView) itemView.findViewById(R.id.tv_traindest);
            textStartTime = (TextView) itemView.findViewById(R.id.tv_starttime);

        }
    }
}
