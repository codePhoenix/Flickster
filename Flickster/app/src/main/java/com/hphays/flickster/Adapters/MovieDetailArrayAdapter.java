package com.hphays.flickster.Adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hphays.flickster.Models.Movie;
import com.hphays.flickster.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


public class MovieDetailArrayAdapter extends ArrayAdapter<Movie> {

    public MovieDetailArrayAdapter(Context context, List<Movie> movies) {
        super(context, R.layout.activity_detail_view, movies);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the data item for position
        Movie movie = getItem(position);

       // if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView =  inflater.inflate(R.layout.activity_detail_view, parent, false);
       // }

            ImageView ivImage = (ImageView) convertView.findViewById(R.id.movieImage);

            ivImage.setImageResource(0);

           TextView movieName = (TextView) convertView.findViewById(R.id.movieName);
           TextView movieOverview = (TextView) convertView.findViewById(R.id.movieOverView);

        movieName.setText(movie.getOriginalTitle());
        movieOverview.setText(movie.getOverview());


        int orientation = getContext().getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(20, 20)).placeholder(R.drawable.movie_placeholder).into(ivImage);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(20, 20)).placeholder(R.drawable.movie_placeholder).into(ivImage);
        }

return convertView;
    }
}
