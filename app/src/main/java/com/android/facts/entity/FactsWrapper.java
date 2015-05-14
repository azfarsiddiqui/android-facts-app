package com.android.facts.entity;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by azfar on 5/14/15.
 */
public class FactsWrapper extends BaseServiceEntity {

    private static final String KEY_JSON_ROWS = "rows";
    private static final String KEY_JSON_TITLE = "title";

    String mTitle;
    ArrayList<Fact> mFacts;

    @Override
    public void deserialize(JSONObject jsonObject) {

        try {
            mTitle = jsonObject.getString(KEY_JSON_TITLE);
            mFacts = new ArrayList<Fact>();

            //Iterate over the json array and deserialize each item
            //to typed object and add it to array list data source

            JSONArray jsonFactsArray = jsonObject.getJSONArray(KEY_JSON_ROWS);

            if (jsonFactsArray == null || jsonFactsArray.length() == 0) return;

            for (int i = 0; i < jsonFactsArray.length(); i++) {

                JSONObject jsonFactObject = jsonFactsArray.getJSONObject(i);
                Fact fact = new Fact();
                fact.deserialize(jsonFactObject);

                //Dont add a fact which does not have a title associated with it
                if (fact.getTitle().length() > 0)
                    mFacts.add(fact);
            }
        } catch (JSONException exception) {
            Log.e(getClass().getName(), exception.getMessage());
        }
    }

    public String getTitle() {

        return mTitle;
    }


    public ArrayList<Fact> getFacts() {

        return mFacts;
    }

}
