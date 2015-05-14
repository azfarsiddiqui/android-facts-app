package com.android.facts.entity;

import com.android.facts.helper.JsonHelper;

import org.json.JSONObject;

/**
 * Created by azfar on 5/14/15.
 */
public class Fact extends BaseServiceEntity {

    private static final String KEY_JSON_TITLE = "title";
    private static final String KEY_JSON_DESCRIPTION = "description";
    private static final String KEY_JSON_IMAGE_URL = "imageHref";

    private String mTitle;
    private String mDescription;
    private String mImageUrl;

    @Override
    public void deserialize(JSONObject jsonObject) {

        mTitle = JsonHelper.getString(jsonObject, KEY_JSON_TITLE);
        mDescription = JsonHelper.getString(jsonObject, KEY_JSON_DESCRIPTION);
        mImageUrl = JsonHelper.getString(jsonObject, KEY_JSON_IMAGE_URL);
    }

    public String getTitle() {

        return mTitle;
    }

    public String getDescription() {

        return mDescription;
    }

    public String getImageUrl() {

        return mImageUrl;
    }
}
