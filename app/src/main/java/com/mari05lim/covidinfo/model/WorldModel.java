package com.mari05lim.covidinfo.model;

import com.google.gson.annotations.SerializedName;

public class WorldModel {

    @SerializedName("lastUpdate")
    private String lastUpdate;
    @SerializedName("confirmed")
    private Confirmed confirmed;
    @SerializedName("deaths")
    private Deaths deaths;
    @SerializedName("recovered")
    private Recovered recovered;

    public WorldModel(String lastUpdate, Confirmed confirmed, Deaths deaths, Recovered recovered) {
        this.lastUpdate = lastUpdate;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public Confirmed getConfirmed() {
        return confirmed;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public Recovered getRecovered() {
        return recovered;
    }

    public class Confirmed {
        @SerializedName("value")
        private int value;

        public Confirmed(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public class Deaths {
        @SerializedName("value")
        private int value;

        public Deaths(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public class Recovered {
        @SerializedName("value")
        private int value;

        public Recovered(int value) {
            this.value = value;

        }
        public int getValue() {
            return value;
        }
    }
}
