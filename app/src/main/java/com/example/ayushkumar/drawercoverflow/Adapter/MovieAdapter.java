package com.example.ayushkumar.drawercoverflow.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ayushkumar.drawercoverflow.Model.Movie;
import com.example.ayushkumar.drawercoverflow.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ayushkumar on 20/02/18.
 */

public class MovieAdapter extends BaseAdapter
{
    List<Movie> moviesList ;
    Context context ;

    public MovieAdapter(List<Movie> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return moviesList.size();
    }

    @Override
    public Object getItem(int i) {
        return moviesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View rootView = view;
        if (rootView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.layout_item, null);

            TextView name = (TextView) itemView.findViewById(R.id.label);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);

            Picasso.with(context).load(moviesList.get(i).getUrl()).into(imageView);
            name.setText(moviesList.get(i).getTitle());

            return itemView;

        }
        return rootView;
    }
}
