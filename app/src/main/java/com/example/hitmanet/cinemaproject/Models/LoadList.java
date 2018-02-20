package com.example.hitmanet.cinemaproject.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Hitmanet on 19.02.2018.
 */

public class LoadList extends Thread {
    private final String KEY="3f9f2a6ac8ab84deac0aceec8a59a3af";
    private static List<Movie> movies;
    @Override
    public void run() {
        super.run();

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body = RequestBody.create(mediaType, "{}");
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/now_playing?page=1&language=ru-RU&region=RU&api_key="+KEY)
                .get()
                .build();
        try {
            movies = new ArrayList<>();
            okhttp3.Response response = client.newCall(request).execute();

            JSONObject o = new JSONObject(response.body().string());
            JSONArray a = o.getJSONArray("results");
            for (int i = 0; i < a.length(); i++) {
                movies.add(new Movie(a.getJSONObject(i).getString("title"),
                        a.getJSONObject(i).getString("poster_path"),
                        a.getJSONObject(i).getString("overview")));
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }

    public static List<Movie> getMovies() {
        return movies;
    }
}
