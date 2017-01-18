package xyz.ahill.Alexa.LondonTransport;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrewhill on 18/01/2017.
 */
public class TransportSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {


    private static final Set<String> supportedApplicationIds;

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds = new HashSet<>();
        supportedApplicationIds.add("amzn1.ask.skill.5c6475b2-fd9a-46f8-92bc-fe4aa121c7e4");
    }


    public TransportSpeechletRequestStreamHandler(SpeechletV2 speechlet, Set<String> supportedApplicationIds) {
        super(speechlet, supportedApplicationIds);
    }

    public TransportSpeechletRequestStreamHandler(Speechlet speechlet, Set<String> supportedApplicationIds) {
        super(speechlet, supportedApplicationIds);
    }
}
