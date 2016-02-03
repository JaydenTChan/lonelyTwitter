package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Tweet class used to store the date and message
 * <p>Created by romansky on 1/12/16.</p>
 */
public abstract class Tweet {
    protected Date date;
    protected String message;

    public abstract Boolean isImportant();

    /**
     * The Constructor
     * @param date the date input for the tweet
     * @param message the message for the tweet
     */
    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    /**
     * The secondary constructor
     * <p>The date is automatically assigned as system time</p>
     *
     * @param message the message for the tweet
     */
    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }


    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
