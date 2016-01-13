package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jayden1 on 1/12/16.
 */
public class normalTweet extends Tweet {
    public normalTweet(Date date, String message) {
        super(date, message);
    }

    public normalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isThisImportant() {
        return Boolean.FALSE;
    }
}
