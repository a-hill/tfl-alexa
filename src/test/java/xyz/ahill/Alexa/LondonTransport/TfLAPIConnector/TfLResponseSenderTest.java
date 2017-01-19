package xyz.ahill.Alexa.LondonTransport.TfLAPIConnector;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by andrewhill on 19/01/2017.
 */
public class TfLResponseSenderTest {

    // 490015048A is teh NaptanId of Westminster Station/Parliament Square.
    // Therefore there should always be arrivals.
    private final String naptanIdWestminsterPariamentSquare = "490015048A";

    @Test
    public void testFetchByNaptanIdOnFirstResponse() {
        System.out.println("calling the api");

        // 490015048A is teh NaptanId of Westminster Station/Parliament Square.
        // Therefore there should always be arrivals.

        TfLStoppointArrivalsResponse[] responses =
                TfLResponseGetter.fetch("/StopPoint/"
                                        + naptanIdWestminsterPariamentSquare
                                        + "/Arrivals");

        if (responses == null) {
            fail("Responses is Null");
        }

        TfLStoppointArrivalsResponse firstResponse = responses[0];

        if (firstResponse == null) {
            fail("No Arrivals OR Gson serialisation failed: responses[0] is null");
        }
        assertThat(firstResponse.getNaptanId(), is(naptanIdWestminsterPariamentSquare));
    }

    @Test
    public void testFetchByNaptanIdOnSecondResponse() {
        System.out.println("calling the api");

        TfLStoppointArrivalsResponse[] responses =
                TfLResponseGetter.fetch("/StopPoint/"
                                        + naptanIdWestminsterPariamentSquare
                                        + "/Arrivals");

        if (responses == null) {
            fail("Responses is Null");
        }

        TfLStoppointArrivalsResponse firstResponse = responses[1];

        if (firstResponse == null) {
            fail("No Arrivals OR Gson serialisation failed: responses[0] is null");
        }
        assertThat(firstResponse.getNaptanId(), is(naptanIdWestminsterPariamentSquare));
    }

}
