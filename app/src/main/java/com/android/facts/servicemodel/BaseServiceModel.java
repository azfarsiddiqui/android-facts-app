package com.android.facts.servicemodel;

import com.android.facts.constant.APIConstants;
import com.android.facts.network.VolleyManager;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by azfar on 5/14/15.
 */
public abstract class BaseServiceModel {

    protected String getCompleteUrl(String method) {

        return APIConstants.API_BASE_URL + method;
    }

    protected void get(String apiMethod, Response.Listener<String> successListener, Response.ErrorListener errorListener) {

        String url = getCompleteUrl(apiMethod);
        StringRequest request = new StringRequest(url, successListener, errorListener);
        request.setShouldCache(false);
        
        VolleyManager.getInstance().getRequestQueue().add(request);
    }
}
