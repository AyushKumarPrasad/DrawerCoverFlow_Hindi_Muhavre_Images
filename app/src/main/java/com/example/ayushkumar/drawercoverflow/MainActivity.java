package com.example.ayushkumar.drawercoverflow;

import android.content.Intent;
import android.content.pm.FeatureGroupInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.ayushkumar.drawercoverflow.Adapter.MovieAdapter;
import com.example.ayushkumar.drawercoverflow.Common.Common;
import com.example.ayushkumar.drawercoverflow.Model.Movie;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity
{
    FeatureCoverFlow coverFlow;
    MovieAdapter adapter;
    TextSwitcher mTitle;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        adapter = new MovieAdapter(Common.movieList,this);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverFlow);
        mTitle = (TextSwitcher) findViewById(R.id.mtitle);

        mTitle.setFactory(new ViewSwitcher.ViewFactory()
        {
            @Override
            public View makeView()
            {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView text = (TextView) inflater.inflate(R.layout.layout_title, null);

                return text;
            }
        });

        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener()
        {
            @Override
            public void onScrolledToPosition(int position)
            {
                mTitle.setText(Common.movieList.get(position).getTitle());
            }

            @Override
            public void onScrolling()
            {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(MainActivity.this, MovieDetail.class);
                intent.putExtra("movie_index",i);
                startActivity(intent);
            }
        });

    }

    private void initData()
    {
        Movie movie = new Movie("Muhavre","https://cdn6.aptoide.com/imgs/f/4/9/f49435af1ab2d681ced6910518bbbe52_icon.jpg?w=240",
                "Muhavre");
        Common.movieList.add(movie);

        movie = new Movie("Famous Muhavre","https://lh3.googleusercontent.com/59hQIo_at0XlY0iJuSwt8kl8j9FRRp6VpozyDwNzgVi9j2-1wkKsvtxD8as2z2yu7Aw=w300",
                "Muhavre");
        Common.movieList.add(movie);

        Common.movieList.add(new Movie("Muhavre aur Vakya",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6W1QPxs7rLElbGfRNreb53J8Lbdc2T2l34MbfdoIxOzY7Zl8M",
                "Muhavre"));

        Common.movieList.add(new Movie("Muhavre Vakya aur Arth",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhB084TPpjaHnEb-csKlf-U514kBQF9fB1EQSFMa3xoPcKVFQK",
                "Muhavre"));


    }
}
