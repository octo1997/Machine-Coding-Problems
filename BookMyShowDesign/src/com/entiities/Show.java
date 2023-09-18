package com.entiities;

import com.Util.Slot;

public class Show {
    private final String showId;
    private String showDetails;

    public Show(String showId, String showDetails) {
        this.showId = showId;
        this.showDetails = showDetails;
    }

    public String getShowId() {
        return showId;
    }

    public String getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }
}
