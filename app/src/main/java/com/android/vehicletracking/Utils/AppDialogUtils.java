package com.android.vehicletracking.Utils;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by EMD802 on 12-11-2016.
 */

public class AppDialogUtils {

    public static ProgressDialog createProgressBar(Activity activity) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        return progressDialog;
    }
}
