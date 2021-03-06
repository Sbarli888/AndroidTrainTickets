package feup.cm.traintickets.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import feup.cm.traintickets.R;
import feup.cm.traintickets.models.TicketModel;

public class TicketListAdapter extends ArrayAdapter<TicketModel> implements View.OnClickListener{

    private List<TicketModel> dataSet;
    private Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtDate;
        TextView txtSeat;
        ImageView info;
    }

    public TicketListAdapter(List<TicketModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;
    }

    public List<TicketModel> getDataSet() {
        return dataSet;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        TicketModel dataModel = (TicketModel) object;
        SimpleDateFormat timef = new SimpleDateFormat("hh:mm", Locale.UK);

        if(dataModel != null) {
            switch (v.getId()) {
                case R.id.item_info:
                    if (dataModel.getDepartureTime() != null) {
                        Snackbar.make(v, String.format("Departure Time: %s",
                                timef.format(dataModel.getDepartureTime())),
                                Snackbar.LENGTH_LONG).setAction("No action", null).show();
                    }
                    break;
            }
        }
    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        TicketModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.date);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

            result=convertView;

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ?
                R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        if(dataModel != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            viewHolder.txtName.setText(dataModel.getDepartureStation().getStationName());
            viewHolder.txtType.setText(dataModel.getArrivalStation().getStationName());
            viewHolder.txtDate.setText(sdf.format(dataModel.getTicketDate()));
            viewHolder.info.setOnClickListener(this);
            viewHolder.info.setTag(position);
        }
        // Return the completed view to render on screen
        return convertView;
    }
}