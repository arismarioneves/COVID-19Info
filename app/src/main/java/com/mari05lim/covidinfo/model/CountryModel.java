package com.mari05lim.covidinfo.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("lastUpdate")
    private String lastUpdate;
    @SerializedName("confirmed")
    private IdnConfirmed idnConfirmed;
    @SerializedName("recovered")
    private IdnRecovered idnRecovered;
    @SerializedName("deaths")
    private IdnDeaths idnDeaths;

    public CountryModel(String lastUpdate, IdnConfirmed idnConfirmed, IdnDeaths idnDeaths, IdnRecovered idnRecovered) {
        this.lastUpdate = lastUpdate;
        this.idnConfirmed = idnConfirmed;
        this.idnDeaths = idnDeaths;
        this.idnRecovered = idnRecovered;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public IdnConfirmed getIdnConfirmed() {
        return idnConfirmed;
    }

    public IdnDeaths getIdnDeaths() {
        return idnDeaths;
    }

    public IdnRecovered getIdnRecovered() {
        return idnRecovered;
    }

    public class IdnConfirmed {
        @SerializedName("value")
        private int value;

        public IdnConfirmed(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public class IdnDeaths {
        @SerializedName("value")
        private int value;

        public IdnDeaths(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public class IdnRecovered {
        @SerializedName("value")
        private int value;

        public IdnRecovered(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
}
