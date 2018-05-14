package com.lily.sensoresinfolily;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends ListActivity implements SensorEventListener {

    private SensorAdapter adapter;
    private List<MySensor> sensorList;

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sensorList = new ArrayList<MySensor>();
        sensorList = getSensors();
        adapter = new SensorAdapter(this, R.layout.list_item, sensorList);
        setListAdapter(adapter);
    }

    public void onSensorChanged(SensorEvent event) {
    }

    private List<MySensor> getSensors() {

        List<MySensor> list = new ArrayList<MySensor>();

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> phoneSensor = sm.getSensorList(Sensor.TYPE_ALL);

        Iterator<Sensor> it = phoneSensor.iterator();
        while (it.hasNext()) {
            Sensor s = it.next();
            list.add(new MySensor(s, getApplicationContext()));
        }

        return list;
    }
}