package xyz.ahill.Alexa.LondonTransport;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import xyz.ahill.Alexa.LondonTransport.Intents.NextBusIntent;

/**
 * Created by andrewhill on 18/01/2017.
 */
public class TransportSpeechlet implements SpeechletV2 {

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> speechletRequestEnvelope) {

    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> speechletRequestEnvelope) {

        String welcomeString = "This is London Transport."
                               + "You can currently ask,"
                               + "When is my next bus,";

        return generateAskResponse(welcomeString, welcomeString);
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> speechletRequestEnvelope) {

        Intent intent = speechletRequestEnvelope.getRequest().getIntent();
        User user = speechletRequestEnvelope.getSession().getUser();
        String intentName = intent.getName();


        if (intentName.equals("nextBus")) {
            //String responseString = NextBusIntent.handleNextBusIntent(user);
            String responseString = "Test Next Bus Intent";

            /* Output the string as a Tell Response */
            OutputSpeech outputSpeech = new PlainTextOutputSpeech();
            ((PlainTextOutputSpeech) outputSpeech).setText(responseString);
            return SpeechletResponse.newTellResponse(outputSpeech);

        } else if ("AMAZON.HelpIntent".equals(intentName)) {

            String welcomeString = "This is London Transport."
                                   + "You can currently ask,"
                                   + "When is my next bus.";

            return generateAskResponse(welcomeString, welcomeString);

        } else if ("AMAZON.StopIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");

            return SpeechletResponse.newTellResponse(outputSpeech);
        } else if ("AMAZON.CancelIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");

            return SpeechletResponse.newTellResponse(outputSpeech);
        } else {
            return null;
        }
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> speechletRequestEnvelope) {

    }

    /**
     * Wrapper for creating the Ask response from the input strings.
     *
     * @param stringOutput
     *            the output to be spoken
     * @param repromptText
     *            the reprompt for if the user doesn't reply or is misunderstood.
     * @return SpeechletResponse the speechlet response
     */
    private SpeechletResponse generateAskResponse(String stringOutput,
                                                  String repromptText) {

        /* Set output speech */
        OutputSpeech outputSpeech, repromptOutputSpeech;
        outputSpeech = new PlainTextOutputSpeech();
        ((PlainTextOutputSpeech) outputSpeech).setText(stringOutput);

        /* Set re-prompt speech */
        repromptOutputSpeech = new PlainTextOutputSpeech();
        ((PlainTextOutputSpeech) repromptOutputSpeech).setText(repromptText);
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);

        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }

}
