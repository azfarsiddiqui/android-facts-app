package com.android.facts.helper;

import org.json.JSONObject;

/**
 * Created by azfar on 5/14/15.
 */
public class JsonHelper {

    public static String getString(JSONObject jsonObject, String key) {

        if (jsonObject.isNull(key)) return "";

        return jsonObject.optString(key).trim();
    }
}
