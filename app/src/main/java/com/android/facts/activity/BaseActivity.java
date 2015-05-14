package com.android.facts.activity;

import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.android.facts.R;

/**
 * Created by azfar on 5/14/15.
 */
public class BaseActivity extends ActionBarActivity {

    protected void showNetworkError() {

        Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show();
    }
}
