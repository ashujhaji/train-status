package io.tnine.trainstatus.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

import io.tnine.trainstatus.Models.ModelLiveTrainStatus.LiveTrainStatusModel;
import io.tnine.trainstatus.Models.Route;
import io.tnine.trainstatus.R;

/**
 * Created by nikun on 16-03-2018.
 */

public class LiveTrainStatusAdapter extends RecyclerView.Adapter<LiveTrainStatusAdapter.TimeLineViewHolder> {

    Context context;
    LiveTrainStatusModel mData;
    List<Route> dataForRecyclerview;

    public LiveTrainStatusAdapter(LiveTrainStatusModel data, Context context) {
        this.context = context;
        mData = data;
        dataForRecyclerview = mData.getRoute();
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.live_train_status_list_item, null);
        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        if(dataForRecyclerview.get(position).getHasDeparted() ){
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(context, R.drawable.ic_marker_active));
        }
        else if(dataForRecyclerview.get(position).getHasDeparted() == false && dataForRecyclerview.get(position).getHasArrived() == false){
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(context, R.drawable.ic_marker_inactive));

        }
        if (dataForRecyclerview.get(position).getHasDeparted() == true && dataForRecyclerview.get(position).getScharr().equals("Source")) {
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(context, R.drawable.ic_marker_active));
        }
        if (dataForRecyclerview.get(position).getHasArrived() == true && dataForRecyclerview.get(position).getSchdep().equals("Destination")) {
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(context, R.drawable.ic_marker_active));
        }

        
        //TODO:SET MARKER ACTIVE FOR EACH ITEM(CURRENTLY INACTIVE) IF ITS SUCCEEDING ITEMS ARE ACTIVE

        if (dataForRecyclerview.get(position).getActarr().equals("00:00")) {
            holder.textActualArrVal.setText("Src");
        }else holder.textActualArrVal.setText(dataForRecyclerview.get(position).getActarr());
        if (dataForRecyclerview.get(position).getActdep().equals("00:00")){
            holder.textActualDepVal.setText("Dest");
        }else holder.textActualDepVal.setText(dataForRecyclerview.get(position).getActdep());

        if (dataForRecyclerview.get(position).getScharr().equals("Source")) {
            holder.textSchArrVal.setText("Src");
        } else holder.textSchArrVal.setText(dataForRecyclerview.get(position).getScharr());

        if (dataForRecyclerview.get(position).getSchdep().equals("Destination")) {
            holder.textSchDepVal.setText("Dest");
        } else holder.textSchDepVal.setText(dataForRecyclerview.get(position).getSchdep());

        holder.textStationName.setText(dataForRecyclerview.get(position).getStation().getName());

    }

    @Override
    public int getItemCount() {
        return dataForRecyclerview.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView textActualDepVal;
        AppCompatTextView textStationName;
        AppCompatTextView textActualArrVal;
        AppCompatTextView textSchArrVal;
        AppCompatTextView textSchDepVal;

        public TimelineView mTimelineView;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);
            mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
            mTimelineView.initLine(viewType);
            textActualDepVal = (AppCompatTextView) itemView.findViewById(R.id.tv_act_dep_val);
            textActualArrVal = (AppCompatTextView) itemView.findViewById(R.id.tv_act_arr_val);
            textSchArrVal = (AppCompatTextView) itemView.findViewById(R.id.tv_sch_arr_val);
            textSchDepVal = (AppCompatTextView) itemView.findViewById(R.id.tv_sch_dep_val);
            textStationName = (AppCompatTextView) itemView.findViewById(R.id.tv_station_name);


        }
    }
}
