package com.my.hackernooz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by my on 6/28/17.
 */

public class RecipeAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Recipe> mDataSource;

    public RecipeAdapter(Context context, ArrayList<Recipe> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //1
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

// 1
        if(convertView == null) {

            // 2
            convertView = mInflater.inflate(R.layout.list_item_recipe, parent, false);

            // 3
            holder = new ViewHolder();
            holder.titleTextView = (TextView) convertView.findViewById(R.id.recipe_list_title);
            holder.subtitleTextView = (TextView) convertView.findViewById(R.id.recipe_list_subtitle);
            holder.detailTextView = (TextView) convertView.findViewById(R.id.recipe_list_detail);

            // 4
            convertView.setTag(holder);
        }
        else{
            // 5
            holder = (ViewHolder) convertView.getTag();
        }

// 6
        TextView titleTextView = holder.titleTextView;
        TextView subtitleTextView = holder.subtitleTextView;
        TextView detailTextView = holder.detailTextView;
        Recipe recipe = (Recipe) getItem(position);

// 2
        titleTextView.setText(recipe.title);
        subtitleTextView.setText(recipe.description);
        detailTextView.setText(recipe.label);
        return convertView;
    }
    private static class ViewHolder {
        public TextView titleTextView;
        public TextView subtitleTextView;
        public TextView detailTextView;
    }
}
