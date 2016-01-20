package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jayden1 on 1/12/16.
 */
public abstract class Tweet implements tweetable {
    private Date date;
    private String message;
    private ArrayList<mood> moodList;

    public abstract Boolean isThisImportant();

    public Tweet(Date date, String message) {
        //message = "Hello All";
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TooLong {
        if (message.length() > 140) {
            throw new TooLong();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }


}
