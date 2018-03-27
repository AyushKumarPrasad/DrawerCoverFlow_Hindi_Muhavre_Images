package com.example.ayushkumar.drawercoverflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ayushkumar.drawercoverflow.Common.Common;
import com.example.ayushkumar.drawercoverflow.Model.Movie;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity
{
    KenBurnsView movie_image;
    TextView movie_title,  summary;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

            movie_image = (KenBurnsView)findViewById(R.id.movie_image);
            movie_title = (TextView) findViewById(R.id.movie_title);
            // summary = (TextView) findViewById(R.id.movie_summary);

        if (getIntent() != null)
        {
            int movie_index = getIntent().getIntExtra("movie_index", -1);
            if (movie_index != -1)
                loadMovieDetail(movie_index);
        }
    }

    private void loadMovieDetail(int index)
    {
            Movie movie = Common.movieList.get(index);

            Picasso.with(getBaseContext()).load(movie.getUrl()).into(movie_image);

            movie_title.setText(movie.getSummary());
    }
}
