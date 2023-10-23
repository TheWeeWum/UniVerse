package main.java.api;

import com.google.gson.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import com.google.maps.*;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

public class GoogleMapsDB implements api.MapDB {
    private static final String API_URL = "";
    private static final String API_TOKEN = "AIzaSyBNWxKThZ-Rq8dU0AH_DOrzJ-itEYicp-E";
    private static final String GEOCODING = "AIzaSyBNWxKThZ-Rq8dU0AH_DOrzJ-itEYicp-E";

    public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        // larger zoom = closer
        String zoom = "15";
        String size = "400x400";
        String scale = "2";

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_TOKEN)
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,
                "27 King's College Cir, Toronto, ON M5S 1A1").await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].addressComponents));

        // Invoke .shutdown() after your application is done making requests
        context.shutdown();

        String UofTMarker = "size:mid|color:red|43.66204186698649,-79.39519371827629|McLennan+Physical+Laboratories,Toronto,ON";

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://maps.googleapis.com/maps/api/staticmap?" +
                        "center=43.66204186698649,-79.39519371827629" +
                        "&zoom=" + zoom +
                        "&size=" + size +
                        "&scale=" + scale +
                        //"&maptype=" + "roadmap" +
                        "&markers=" + UofTMarker +
                        "&key=" + API_TOKEN))
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
