package com.android.facts.servicemodel;

import com.android.facts.entity.FactsWrapper;
import com.android.facts.listener.FactServiceModelListener;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by azfar on 5/14/15.
 */
public class FactServiceModel extends BaseServiceModel {

    private static final String API_METHOD_FACTS = "facts.json";

    private FactServiceModelListener mFactServiceModelListener;

    public FactServiceModel(FactServiceModelListener factServiceModelListener) {

        mFactServiceModelListener = factServiceModelListener;
    }

    public void fetchAllFacts() {

        super.get(API_METHOD_FACTS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String json) {

                        try {
                            JSONObject factsWrapperJsonObject = new JSONObject(json);
                            FactsWrapper factsWrapperObject = new FactsWrapper();
                            factsWrapperObject.deserialize(factsWrapperJsonObject);

                            mFactServiceModelListener.onFactsFetchSuccess(factsWrapperObject);

                        } catch (JSONException e) {

                            mFactServiceModelListener.onFactsFetchError(e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        mFactServiceModelListener.onFactsFetchError(volleyError.getMessage());
                    }
                }
        );
    }

}
