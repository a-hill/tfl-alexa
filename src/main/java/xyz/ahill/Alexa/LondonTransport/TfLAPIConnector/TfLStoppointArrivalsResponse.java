package xyz.ahill.Alexa.LondonTransport.TfLAPIConnector;

/**
 * Created by andrewhill on 18/01/2017.
 */
public class TfLStoppointArrivalsResponse {

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
    private String modeName;

    /* Empty Constructor for Gson Serialisation */
    public TfLStoppointArrivalsResponse() {
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

    public String getModeName() {
        return modeName;
    }

    @Override
    public String toString() {
        return "TfLStoppointArrivalsResponse{"
               + "naptanId='"
               + naptanId
               + '\''
               + ", vehicleId='"
               + vehicleId
               + '\''
               + ", stationName='"
               + stationName
               + '\''
               + ", lineId='"
               + lineId
               + '\''
               + ", lineName='"
               + lineName
               + '\''
               + ", platformName='"
               + platformName
               + '\''
               + ", direction='"
               + direction
               + '\''
               + ", bearing='"
               + bearing
               + '\''
               + ", destinationNaptanId='"
               + destinationNaptanId
               + '\''
               + ", destinationName='"
               + destinationName
               + '\''
               + ", timestamp='"
               + timestamp
               + '\''
               + ", timeToStation='"
               + timeToStation
               + '\''
               + ", currentLocation='"
               + currentLocation
               + '\''
               + ", towards='"
               + towards
               + '\''
               + ", expectedArrival='"
               + expectedArrival
               + '\''
               + ", modeName='"
               + modeName
               + '\''
               + '}';
    }
}