package xyz.ahill.Alexa.LondonTransport.TfLAPIConnector;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by andrewhill on 18/01/2017.
 */

public class TfLResponseGetter {

    public static final String API_BASE_URL = "http://api.tfl.gov.uk";

    public static void main(String[] args) {
        System.out.println("calling the api");

        TfLStoppointArrivalsResponse[] responses = fetch("https://api.tfl.gov.uk/StopPoint/490008677S/Arrivals");

        for (int i = 0; i < responses.length; i++) {
            System.out.println();
            System.out.println(responses[i]);
            System.out.println();
        }
    }

    public static TfLStoppointArrivalsResponse[] fetch(String path) {

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            String url = API_BASE_URL + path;
            HttpGet request = new HttpGet(url);
            //StringEntity params = new StringEntity(body);
            request.addHeader("content-type", "application/json");
            //request.setEntity(params);
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");

            Gson gson = new Gson();
            TfLStoppointArrivalsResponse[] responses = gson.fromJson(json, TfLStoppointArrivalsResponse[].class);
            return responses;
        } catch (IOException ex) {
            System.err.println("");
            return null;

        }
    }

}
