package xyz.ahill.Alexa.LondonTransport.TfLAPIConnector;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by andrewhill on 19/01/2017.
 */

public class StopPointArrivalsResponseTest {

    // 490015048A is teh NaptanId of Westminster Station/Parliament Square.
    // Therefore there should always be arrivals.
    private final String naptanIdWestminsterPariamentSquare = "490015048A";

    private final LinkedList<StopPointArrivalsResponse> responses =
            StopPointArrivalsResponseListBuilder
                    .start()
                    .withNaptanId(naptanIdWestminsterPariamentSquare)
                    .build();

    @Test
    public void testFetchByNaptanIdOnFirstBus() {
        StopPointArrivalsResponse firstResponse = responses.get(0);
        assertThat(firstResponse.getNaptanId(),
                is(naptanIdWestminsterPariamentSquare));
    }

    @Test
    public void testFetchByNaptanIdOnSecondBus() {
        StopPointArrivalsResponse firstResponse = responses.get(1);
        assertThat(firstResponse.getNaptanId(),
                is(naptanIdWestminsterPariamentSquare));
    }

}
