package com.gokhanoguz.goeuro.model;

/**
 * Created with IntelliJ IDEA.
 * User: gokhan
 * Date: 24.04.2015
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class GeoPosition {
    private Float latitude;
    private Float longitude;

    public GeoPosition() {
    }

    public GeoPosition(Float latitude, Float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
