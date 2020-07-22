package com.example.covid_19.model;

import com.google.gson.annotations.SerializedName;

public class World {

    @SerializedName("cases")
    private int worldTotal;
    @SerializedName("recovered")
    private int worldRecovered;
    @SerializedName("deaths")
    private int worldDeaths;
    @SerializedName("todayCases")
    private int worldCasesToday;
    @SerializedName("todayDeaths")
    private int worldDeathsToday;;
    @SerializedName("todayRecovered")
    private long worldRecoveredToday;

    public  World(
            int worldCasesToday, int worldRecoveredToday, int worldDeathsToday,
            int worldDeaths, int worldRecovered, int worldTotal
    )
    {
        this.worldCasesToday = worldCasesToday;
        this.worldRecoveredToday = worldRecoveredToday;
        this.worldDeathsToday = worldDeathsToday;
        this.worldTotal = worldTotal;
        this.worldDeaths = worldDeaths;
        this.worldRecovered = worldRecovered;

    }

    public int getWorldTotal() {
        return worldTotal;
    }

    public int getWorldRecovered() {
        return worldRecovered;
    }

    public int getWorldDeaths() {
        return worldDeaths;
    }

    public int getWorldCasesToday() {
        return worldCasesToday;
    }

    public int getWorldDeathsToday() {
        return worldDeathsToday;
    }

    public long getWorldRecoveredToday() {
        return worldRecoveredToday;
    }
}
