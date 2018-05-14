package com.lily.sensoresinfolily;


import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.os.Build;

public class MySensor {

    private final static String MICRO = "&amp;#x3BC;";
    private static final int SDK = Build.VERSION.SDK_INT;
    private final static String SQUARE = "&amp;#xB2;";
    private Context context;
    private float maximumRange, minDelay, power, resolution;
    private String name, vendor;
    private int type, version;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public MySensor(Sensor sensor, Context context) {
        this.name = sensor.getName();
        this.vendor = sensor.getVendor();
        this.type = sensor.getType();
        this.version = sensor.getVersion();
        this.maximumRange = sensor.getMaximumRange();
        if (SDK >= Build.VERSION_CODES.GINGERBREAD)
            this.minDelay = sensor.getMinDelay();
        this.power = sensor.getPower();
        this.resolution = sensor.getResolution();
        this.context = context;
    }

    public String getDelayUnits() {
        return MICRO + "s";
    }

    public float getMaximumRange() {
        return maximumRange;
    }

    public float getMinDelay() {
        return minDelay;
    }

    public String getName() {
        return name;
    }

    public float getPower() {
        return power;
    }

    public String getPowerUnits() {
        return "mA";
    }

    public float getResolution() {
        return resolution;
    }

    public int getType() {
        return type;
    }

    public String getTypeDescription() {
        String description = null;

        switch (type) {
            case Sensor.TYPE_ACCELEROMETER:
                description = context.getResources().getString(
                        R.string.accelerometer);
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                description = context.getResources().getString(
                        R.string.ambient_temperature);
                break;
            case Sensor.TYPE_GRAVITY:
                description = context.getResources().getString(R.string.gravity);
                break;
            case Sensor.TYPE_GYROSCOPE:
                description = context.getResources().getString(R.string.gyroscope);
                break;
            case Sensor.TYPE_LIGHT:
                description = context.getResources().getString(R.string.light);
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                description = context.getResources().getString(
                        R.string.linear_acceleration);
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                description = context.getResources().getString(
                        R.string.magnetic_field);
                break;
            case Sensor.TYPE_ORIENTATION:
                description = context.getResources()
                        .getString(R.string.orientation);
                break;
            case Sensor.TYPE_PRESSURE:
                description = context.getResources().getString(R.string.pressure);
                break;
            case Sensor.TYPE_PROXIMITY:
                description = context.getResources().getString(R.string.proximity);
                break;
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                description = context.getResources().getString(
                        R.string.relative_humidity);
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                description = context.getResources().getString(
                        R.string.rotation_vector);
                break;
            case Sensor.TYPE_TEMPERATURE:
                description = context.getResources()
                        .getString(R.string.temperature);
                break;
            default:
                description = context.getResources().getString(R.string.unknown);
                break;
        }

        return description;
    }

    public String getUnits() {
        String units = null;

        switch (type) {
            case Sensor.TYPE_ACCELEROMETER:
                units = "m/s" + SQUARE;
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                units = "°C";
                break;
            case Sensor.TYPE_GRAVITY:
                units = "m/s" + SQUARE;
                break;
            case Sensor.TYPE_GYROSCOPE:
                units = "rad/s";
                break;
            case Sensor.TYPE_LIGHT:
                units = "SI lux";
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                units = "m/s" + SQUARE;
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                units = MICRO + "T";
                break;
            case Sensor.TYPE_ORIENTATION:
                units = "°";
                break;
            case Sensor.TYPE_PRESSURE:
                units = "hPa";
                break;
            case Sensor.TYPE_PROXIMITY:
                units = "cm";
                break;
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                units = "";
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                units = "";
                break;
            case Sensor.TYPE_TEMPERATURE:
                units = "°C";
                break;
            default:
                units = "unknown";
                break;
        }

        return units;
    }

    public String getVendor() {
        return vendor;
    }

    public int getVersion() {
        return version;
    }

    public void setMaximumRange(float maximumRange) {
        this.maximumRange = maximumRange;
    }

    public void setMinDelay(float minDelay) {
        this.minDelay = minDelay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public void setResolution(float resolution) {
        this.resolution = resolution;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return name;
    }

}