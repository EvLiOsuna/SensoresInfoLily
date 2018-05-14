package com.lily.sensoresinfolily;


import java.util.List;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorAdapter extends ArrayAdapter<MySensor> {

    private static final int SDK = Build.VERSION.SDK_INT;
    private int resource;

    public SensorAdapter(Context context, int resource, List<MySensor> items) {
        super(context, resource, items);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout newView;

        if (convertView == null) {
            newView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, newView, true);
        } else {
            newView = (LinearLayout) convertView;
        }

        TextView nameView = (TextView) newView.findViewById(R.id.nameView);
        TextView vendorView = (TextView) newView.findViewById(R.id.vendorView);
        TextView typeView = (TextView) newView.findViewById(R.id.typeView);
        TextView versionView = (TextView) newView
                .findViewById(R.id.versionView);
        TextView maximumRangeView = (TextView) newView
                .findViewById(R.id.maximumRangeView);
        TextView minDelayView = (TextView) newView
                .findViewById(R.id.minDelayView);
        TextView powerView = (TextView) newView.findViewById(R.id.powerView);
        TextView resolutionView = (TextView) newView
                .findViewById(R.id.resolutionView);
        TextView unitsRangeView = (TextView) newView
                .findViewById(R.id.unitsRangeView);
        TextView unitsResolutionView = (TextView) newView
                .findViewById(R.id.unitsResolutionView);
        TextView unitsDelayView = (TextView) newView
                .findViewById(R.id.unitsDelayView);
        TextView unitsPowerView = (TextView) newView
                .findViewById(R.id.unitsPowerView);

        if (SDK < Build.VERSION_CODES.GINGERBREAD) {
            TextView minDelayLabel = (TextView) newView
                    .findViewById(R.id.minDelayLabel);
            minDelayLabel.setVisibility(View.GONE);
            minDelayView.setVisibility(View.GONE);
            unitsDelayView.setVisibility(View.GONE);
        }

        MySensor mySensor = getItem(position);

        nameView.setText(mySensor.getName());
        vendorView.setText(mySensor.getVendor());
        typeView.setText(mySensor.getTypeDescription());
        versionView.setText(String.valueOf(mySensor.getVersion()));
        maximumRangeView.setText(String.valueOf(mySensor.getMaximumRange()));
        if (SDK >= Build.VERSION_CODES.GINGERBREAD)
            minDelayView.setText(String.valueOf(mySensor.getMinDelay()));
        powerView.setText(String.valueOf(mySensor.getPower()));
        resolutionView.setText(String.format("%f", mySensor.getResolution()));
        unitsRangeView.setText(Html.fromHtml(mySensor.getUnits()));
        unitsResolutionView.setText(Html.fromHtml(mySensor.getUnits()));
        if (SDK >= Build.VERSION_CODES.GINGERBREAD)
            unitsDelayView.setText(Html.fromHtml(mySensor.getDelayUnits()));
        unitsPowerView.setText(Html.fromHtml(mySensor.getPowerUnits()));

        return newView;

    }
}