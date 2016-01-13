package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jayden1 on 1/12/16.
 */
public abstract class mood {
    private Date date;

    public abstract String whatMood();

    public mood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
