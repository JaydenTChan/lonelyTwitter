package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jayden1 on 1/12/16.
 */
public class importantTweets extends Tweet {
    //Super calls the constructor from the parent object

    public importantTweets(Date date, String message) {
        super(date, message);
    }

    public importantTweets(String message) {
        super(message);
    }

    @Override
    public Boolean isThisImportant() {
        return Boolean.TRUE;
    }
}