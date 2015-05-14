package com.android.facts.entity;

import org.json.JSONObject;

/**
 * Created by azfar on 5/14/15.
 */
public abstract class BaseServiceEntity {

    //This method should be used to convert JSON representation
    //to a typed object
    protected abstract void deserialize(JSONObject jsonObject);
}
