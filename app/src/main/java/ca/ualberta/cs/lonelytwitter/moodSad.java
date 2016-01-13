package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jayden1 on 1/12/16.
 */
public class moodSad extends mood{
    public moodSad(Date date) {
        super(date);
    }

    @Override
    public String whatMood() {
        return "S";
    }
}
