package com.hphays.flickster;

import android.app.Activity;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.hphays.flickster.Adapters.MovieArrayAdapter;
import com.hphays.flickster.Adapters.MovieDetailArrayAdapter;
import com.hphays.flickster.Models.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static com.loopj.android.http.AsyncHttpClient.log;
import static java.lang.System.load;

public class DetailViewActivity extends AppCompatActivity {

    ArrayList<Movie> movie;
    MovieDetailArrayAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        String movieId = getIntent().getStringExtra("movieId");
        String url = movieId.format("https://api.themoviedb.org/3/movie/%s?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed", movieId);

        String movieImage = getIntent().getStringExtra("movieImage");

        ImageView ivImage = (ImageView) findViewById(R.id.movieImage);

        TextView movieName = (TextView) findViewById(R.id.movieName);
        TextView movieOverview = (TextView) findViewById(R.id.movieOverView);

        RatingBar movieRating = (RatingBar) findViewById(R.id.ratingBar);

        String android_id= Settings.Secure.getString(DetailViewActivity.this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        //getContext() is not working
        //Picasso.with(getContext()).load(getIntent().getStringExtra("movieImage")).transform(new RoundedCornersTransformation(20, 20)).placeholder(R.drawable.movie_placeholder).into(ivImage);

        movieName.setText(getIntent().getStringExtra("movieTitle"));
        movieOverview.setText(getIntent().getStringExtra("movieOverview"));

        Bundle bundle = getIntent().getExtras();
        float myFloat = bundle.getFloat("movieRating");

        movieRating.setRating(myFloat / 2);
    }
}
