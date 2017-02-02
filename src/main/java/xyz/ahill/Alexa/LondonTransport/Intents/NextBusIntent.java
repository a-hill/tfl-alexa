package xyz.ahill.Alexa.LondonTransport.Intents;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.User;
import xyz.ahill.Alexa.LondonTransport.TfLAPIConnector.StopPointArrivalsResponse;
import xyz.ahill.Alexa.LondonTransport.TfLAPIConnector.StopPointArrivalsResponseListBuilder;
import xyz.ahill.Alexa.LondonTransport.TfLAPIConnector.TfLResponse;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by andrewhill on 21/01/2017.
 */
public class NextBusIntent {


    public static String handleNextBusIntent(User user) {

        /* Fixed NaptanID */
        LinkedList<StopPointArrivalsResponse> listOfArrivals =
                StopPointArrivalsResponseListBuilder.start().withNaptanId("490008677N").build();

        listOfArrivals.sort((o1, o2) -> new Integer(o1.getTimeToStation()).compareTo(o2.getTimeToStation()));

        String response = "";

        for (int i = 0; i < listOfArrivals.size(); i++) {
            StopPointArrivalsResponse arrival = listOfArrivals.get(i);

            /* Limit to 30 mins of responses or to 5 next buses */
            if (arrival.getTimeToStation() / 60 > 30 || i > 5) {
                break;
            }

            response += " A " + arrival.getLineName() + " bus to " + arrival.getDestinationName()
                      + " arrives in " + arrival.getTimeToStation() / 60 + " minuites.";
        }

        return response;
    }
}
