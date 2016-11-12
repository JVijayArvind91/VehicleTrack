package com.android.vehicletracking;

import android.app.Application;
import android.os.Handler;

/**
 * Created by EMD802 on 12-11-2016.
 */

public class VehicleTrackingApplication extends Application {

    private static VehicleTrackingApplication mVehicleTrackingApplication;

    private static Handler mApplicationHandler;

    public static Application getInstance() {
        return mVehicleTrackingApplication;
    }

    public static Handler getApplicationHandler() {
        return mApplicationHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mVehicleTrackingApplication = this;
        InItInitializer();
    }

    private void InItInitializer() {
        mApplicationHandler = new Handler();
    }
}
