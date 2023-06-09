package com.wileyedge.flighttracker.dao.entity;

import java.util.Objects;

public class Geography {

    private double lat;
    private double lng;
    private double alt;
    private double dir;
    private double speed;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }

    public double getDir() {
        return dir;
    }

    public void setDir(double dir) {
        this.dir = dir;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geography geography = (Geography) o;
        return Double.compare(geography.lat, lat) == 0 && Double.compare(geography.lng, lng) == 0 && Double.compare(geography.alt, alt) == 0 && Double.compare(geography.dir, dir) == 0 && Double.compare(geography.speed, speed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lng, alt, dir, speed);
    }
}
