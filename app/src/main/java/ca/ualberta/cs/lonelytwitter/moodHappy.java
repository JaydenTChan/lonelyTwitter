package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jayden1 on 1/12/16.
 */
public class moodHappy extends mood {
    public moodHappy(Date date) {
        super(date);
    }

    @Override
    public String whatMood() {
        return "H";
    }
}
