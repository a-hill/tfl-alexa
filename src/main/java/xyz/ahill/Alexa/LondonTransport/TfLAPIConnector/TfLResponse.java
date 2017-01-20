package xyz.ahill.Alexa.LondonTransport.TfLAPIConnector;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andrewhill on 19/01/2017.
 */

public abstract class TfLResponse {

    public static final String API_BASE_URL = "http://api.tfl.gov.uk";

    public static String getJsonResponse(String path) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            String url = API_BASE_URL + path;
            HttpGet request = new HttpGet(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            return json;
        } catch (IOException ex) {
            System.err.println("HTTP Request to TfL Failed");
            return "";
        }
    }

    public static Date getDateObject(String timestamp) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return format.parse(timestamp);
        } catch (ParseException e) {
            System.err.println("Parse of Date Failed");
            return null;
        }
    }


}
