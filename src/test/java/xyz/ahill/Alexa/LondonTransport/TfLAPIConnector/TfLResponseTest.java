package xyz.ahill.Alexa.LondonTransport.TfLAPIConnector;

import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by andrewhill on 19/01/2017.
 */

public class TfLResponseTest {

    // 490015048A is teh NaptanId of Westminster Station/Parliament Square.
    // Therefore there should always be arrivals.
    private final String naptanIdWestminsterPariamentSquare = "490015048A";

    private final LinkedList<StopPointArrivalsResponse> responses =
            StopPointArrivalsResponseListBuilder
                    .start()
                    .withNaptanId(naptanIdWestminsterPariamentSquare)
                    .build();

    /* Local Tests */
    @Test
    public void dateCreationFromStringTimestamFormat() {
        Date dateObject = TfLResponse.getDateObject("2017-01-20T01:16:13Z");
        assertThat(dateObject.toString(), is("Fri Jan 20 01:16:13 GMT 2017"));
    }

    @Test
    public void dateCreationFromStringExpectedArrivalFormat() {
        Date dateObject = TfLResponse.getDateObject("2017-01-20T01:20:46.8420475Z");
        assertThat(dateObject.toString(), is("Fri Jan 20 01:20:46 GMT 2017"));
    }

    /* Tests requiring API calls */
    @Test
    public void apiDateCreationFromStringTimestamp() {
        Date dateObject = TfLResponse.getDateObject(responses.getFirst().getTimestamp());
        System.out.println(dateObject.toString());
    }

    @Test
    public void apiDateCreationFromStringExpectedArrival() {
        Date dateObject = TfLResponse.getDateObject(responses.getFirst().getExpectedArrival());
        System.out.println(dateObject.toString());
    }

}
