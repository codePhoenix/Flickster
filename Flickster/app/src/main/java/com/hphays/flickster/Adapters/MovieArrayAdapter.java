package com.hphays.flickster.Adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.WindowManager;

import com.hphays.flickster.R;
import com.hphays.flickster.Models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static android.R.attr.orientation;
import static android.R.attr.rotation;

import static com.hphays.flickster.R.id.ivMovieImage;

/**
 * Created by hhays on 11/8/16.
 */



public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {

        TextView tvTitle;
        TextView tvOverview;
        ImageView posterPath;

    }

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the data item for position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        ViewHolder viewHolder;

        // view lookup cache stored in tag
        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row

            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);


            ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);

            //clear out image from convertView
            ivImage.setImageResource(0);
            viewHolder.posterPath = ivImage;
            //clear out image from convertView
            ivImage.setImageResource(0);

            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {

            // View is being recycled, retrieve the viewHolder object from tag

            viewHolder = (ViewHolder) convertView.getTag();

        }


        // Populate the data from the data object via the viewHolder object
        // into the template view.

        viewHolder.tvTitle.setText(movie.getOriginalTitle());

        viewHolder.tvOverview.setText(movie.getOverview());


        int orientation = getContext().getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(20, 20)).placeholder(R.drawable.movie_placeholder).into(viewHolder.posterPath);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(20, 20)).placeholder(R.drawable.movie_placeholder).into(viewHolder.posterPath);
        }

        return convertView;
    }





}
