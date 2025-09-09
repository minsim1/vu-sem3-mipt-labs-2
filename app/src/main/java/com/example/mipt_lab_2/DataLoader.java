package com.example.mipt_lab_2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Thank you chat gpt
public class DataLoader {
    private static final String TAG = "DataLoader";
    private static final String ENDPOINT = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    public String fetchData() {
        Log.i(TAG, "Called fetch data method");

        StringBuilder result = new StringBuilder();

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(ENDPOINT);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error fetching data", e);
            return null;
        } finally {
            try {
                if (reader != null) reader.close();
                if (connection != null) connection.disconnect();
            } catch (Exception e) {
                Log.e(TAG, "Error closing resources", e);
            }
        }

        return result.toString(); // raw XML
    }
}