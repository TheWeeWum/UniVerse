package api;


import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

import com.google.maps.*;

public class GoogleMapsDB implements MapDB {
    private static final String API_URL = "https://grade-logging-api.chenpan.ca/api/grade";
    private static final String API_TOKEN = "AIzaSyDLpnNhqtRyoYo9drm_7KFaY1XEjpsiuvo";


    public static void main(String[] args) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIza...")
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,
                "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].addressComponents));

// Invoke .shutdown() after your application is done making requests
        context.shutdown();

//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        Request request = new Request.Builder()
//                .url(String.format("https://maps.googleapis.com/maps/api/js?"))
//                .addHeader("key=", API_TOKEN)
//                .addHeader("callback", "initMap")
//                        .addHeader("libraries", "")
//                        .addHeader("v", "weekly")
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response);
//        } catch (IOException | JSONException e) {
//            throw new RuntimeException(e);
//        }
    }
}
