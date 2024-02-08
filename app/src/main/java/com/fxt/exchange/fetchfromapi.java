package com.fxt.exchange;


    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

    public class fetchfromapi {
        public static void main(String[] args) {
            String apiUrl = "https://dummyjson.com/users";

            try {
                // Create a URL object with the API URL
                URL url = new URL(apiUrl);

                // Open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Set the request method to GET
                connection.setRequestMethod("GET");

                // Get the response code
                int responseCode = connection.getResponseCode();

                // Check if the response code is 200 (OK)
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Create a BufferedReader to read the response
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    StringBuilder response = new StringBuilder();

                    // Read the response line by line
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    // Close the reader and the connection
                    reader.close();
                    connection.disconnect();

                    // Print the response
                    System.out.println(response);
                } else {
                    System.out.println("Failed to fetch data. Response code: " + responseCode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


