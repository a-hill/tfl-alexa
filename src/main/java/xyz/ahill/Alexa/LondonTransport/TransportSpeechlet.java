package xyz.ahill.Alexa.LondonTransport;

import com.amazon.speech.speechlet.*;

/**
 * Created by andrewhill on 18/01/2017.
 */
public class TransportSpeechlet implements Speechlet {
    @Override
    public void onSessionStarted(SessionStartedRequest sessionStartedRequest, Session session) throws
                                                                                               SpeechletException {

    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
        return null;
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) throws SpeechletException {
        return null;
    }

    @Override
    public void onSessionEnded(SessionEndedRequest sessionEndedRequest, Session session) throws SpeechletException {

    }
}
