package com.android.facts;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.android.facts.network.VolleyManager;

/**
 * Created by azfar on 5/14/15.
 */
public class FactsApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        initializeVolley();
    }

    private void initializeVolley() {

        int memoryClass = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
        int cacheSize = memoryClass * 1024 / 4;

        //Initialize volley framework
        VolleyManager.initialize(this, cacheSize);
    }

}
