package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverterService {
    private static final String API_KEY = "ba072b022e3383a07f02988c"; // Replace with a valid key
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + "ba072b022e3383a07f02988c" + "/latest/";

    public static double getExchangeRate(String from, String to) throws Exception {
        URL url = new URL(API_URL + from);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Parse JSON response
        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONObject rates = jsonResponse.getJSONObject("conversion_rates");

        return rates.getDouble(to);
    }
}
