package com.android.vehicletracking.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.android.vehicletracking.R;
import com.android.vehicletracking.Utils.AppConstants;
import com.android.vehicletracking.VehicleTrackingApplication;


public class SplashScreenActivity extends BaseActivity implements Runnable{

    private final static int SPLASH_SCREEN_TIME_OUT = 3 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        VehicleTrackingApplication.getApplicationHandler().postDelayed(this, SPLASH_SCREEN_TIME_OUT);
    }

    @Override
    public void run() {
        moveToCorrespondingPage(AppConstants.SCREEN_LOGIN_PAGE);
    }
}
