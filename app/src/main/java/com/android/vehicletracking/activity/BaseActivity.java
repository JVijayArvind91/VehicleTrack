package com.android.vehicletracking.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.vehicletracking.R;
import com.android.vehicletracking.Utils.AppConstants;
import com.android.vehicletracking.Utils.AppDialogUtils;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void createProgressBar() {
        if (mProgressDialog == null) {
            mProgressDialog = AppDialogUtils.createProgressBar(this);
        }

        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    public void removeProgressBar() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void moveToCorrespondingPage(int pageValue) {
        Intent intent;
        switch (pageValue) {
            case AppConstants.SCREEN_LOGIN_PAGE:
                intent = new Intent(this, LoginPageActivity.class);
                break;
            default:
                intent = new Intent(this, LoginPageActivity.class);
                break;
        }
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.abc_popup_enter, R.anim.abc_popup_exit);
    }
}
