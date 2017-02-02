package xyz.ahill.Alexa.LondonTransport.Intents;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrewhill on 02/02/2017.
 */
public class NextBusIntentTest {

    @Test
    public void nextBusTest() {
        String reply = NextBusIntent.handleNextBusIntent(null);
        System.out.println(reply);
        assertNotEquals(reply, "");
    }

}