package com.android.facts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.facts.R;
import com.android.facts.entity.Fact;
import com.android.facts.network.VolleyManager;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by azfar on 5/14/15.
 */
public class FactListAdapter extends BaseAdapter {

    ArrayList<Fact> mFacts;
    Context mContext;

    public FactListAdapter(ArrayList<Fact> facts, Context context) {

        mFacts = facts;
        mContext = context;
    }

    @Override
    public int getCount() {

        return mFacts.size();
    }

    @Override
    public Object getItem(int position) {

        return mFacts.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Fact fact = (Fact) getItem(position);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_fact, parent, false);
        }

        return updateViewForFact(convertView, fact);
    }

    private View updateViewForFact(View view, Fact fact) {

        TextView txtTitle = (TextView) view.findViewById(R.id.txt_title);
        TextView txtDescription = (TextView) view.findViewById(R.id.txt_description);
        NetworkImageView imageView = (NetworkImageView) view.findViewById(R.id.img_thumbnail);

        txtTitle.setText(fact.getTitle());
        txtDescription.setText(fact.getDescription());

        String imageUrl = fact.getImageUrl();

        //Only show the ImageView when we have a image url
        //Also set a default image to show when loading is in progress
        if (imageUrl != null && imageUrl.length() > 0) {
            imageView.setDefaultImageResId(R.mipmap.ic_launcher);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageUrl(imageUrl, VolleyManager.getInstance().getImageLoader());
        } else {
            imageView.setVisibility(View.GONE);
        }

        return view;
    }
}
