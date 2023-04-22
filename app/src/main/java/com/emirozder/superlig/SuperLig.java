package com.emirozder.superlig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuperLig {
    @SerializedName("overall_league_PTS")
    @Expose
    private String overallLeaguePTS;

    public String getOverallLeaguePTS() {
        return overallLeaguePTS;
    }

    public void setOverallLeaguePTS(String overallLeaguePTS) {
        this.overallLeaguePTS = overallLeaguePTS;
    }
}
