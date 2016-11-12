package com.hphays.flickster.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hhays on 11/8/16.
 */

public class Movie {
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w1000/%s", backdropPath);
    }

    public String getOriginalTitle() {

        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getId() {
        return id;
    }

    String posterPath;
    String backdropPath;
    String originalTitle;
    String overview;
    String id;

    public Float getMovieRating() {
        return movieRating;
    }

    Float movieRating;





    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.id = jsonObject.getString("id");
        this.movieRating = Float.valueOf(jsonObject.getString("vote_average"));
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}


