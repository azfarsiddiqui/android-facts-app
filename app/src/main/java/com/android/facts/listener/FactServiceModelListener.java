package com.android.facts.listener;

import com.android.facts.entity.FactsWrapper;

/**
 * Created by azfar on 5/14/15.
 */
public interface FactServiceModelListener {

    public void onFactsFetchSuccess(FactsWrapper factsWrapperObject);
    public void onFactsFetchError(String error);
}
