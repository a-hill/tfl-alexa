package xyz.ahill.Alexa.LondonTransport.TfLAPIConnector;

/**
 * Created by andrewhill on 18/01/2017.
 */

public class StopPointArrivalsResponse extends TfLResponse {

    private String id;
    private String naptanId;
    private String vehicleId;
    private String stationName;
    private String lineId;
    private String lineName;
    private String platformName;
    private String direction;
    private String bearing;
    private String destinationNaptanId;
    private String destinationName;
    private String timestamp;
    private String timeToStation;
    private String currentLocation;
    private String towards;
    private String expectedArrival;
    private String timeToLive;
    private String modeName;

    /* Empty Constructor for Gson Serialisation */
    StopPointArrivalsResponse() {

    }

    /* Getters */

    public String getId() {
        return id;
    }

    public String getNaptanId() {
        return naptanId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getStationName() {
        return stationName;
    }

    public String getLineId() {
        return lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getDirection() {
        return direction;
    }

    public String getBearing() {
        return bearing;
    }

    public String getDestinationNaptanId() {
        return destinationNaptanId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTimeToStation() {
        return timeToStation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getTowards() {
        return towards;
    }

    public String getExpectedArrival() {
        return expectedArrival;
    }

    public String getTimeToLive() {
        return timeToLive;
    }

    public String getModeName() {
        return modeName;
    }
}