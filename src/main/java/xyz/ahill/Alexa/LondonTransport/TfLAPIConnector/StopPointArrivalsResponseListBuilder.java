package xyz.ahill.Alexa.LondonTransport.TfLAPIConnector;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by andrewhill on 19/01/2017.
 */

public class StopPointArrivalsResponseListBuilder {

    private String naptanId;

    public static StopPointArrivalsResponseListBuilder start() {
        return new StopPointArrivalsResponseListBuilder();
    }

    public StopPointArrivalsResponseListBuilder withNaptanId(String naptanId) {
        this.naptanId = naptanId;
        return this;
    }

    public LinkedList<StopPointArrivalsResponse> build() {
        /* Generate API Path */
        String path = generatePath();

        /* Make request */
        String json = TfLResponse.getJsonResponse(path);

        /* Process Json and create responses array */
        Gson gson = new Gson();
        StopPointArrivalsResponse[] responses
                = gson.fromJson(json, StopPointArrivalsResponse[].class);

        /* Convert array to List */
        return new LinkedList<>(Arrays.asList(responses));
    }

    private String generatePath() {
        return "/StopPoint/" + naptanId + "/Arrivals";
    }

}
