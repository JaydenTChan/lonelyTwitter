package ca.ualberta.cs.lonelytwitter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

//Removed unused import
//import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import io.searchbox.annotations.JestId;

public abstract class Tweet {
    @JestId
    private String id; //Changed to private

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Changed to local.
    Date date;
    String message;

    //Changed to private
    private transient Bitmap thumbnail;
    private String thumbnailBase64;

    public Tweet(Date date, String message, Bitmap thumbnail) {
        this.date = date;
        this.message = message;
        this.thumbnail = thumbnail;
    }

    //Changed to local
    Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    //Changed to local
    Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public void addThumbnail(Bitmap newThumbnail){
        if (newThumbnail != null) {
            thumbnail = newThumbnail;
            ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
            newThumbnail.compress(Bitmap.CompressFormat.PNG, 100, byteArrayBitmapStream);

            byte[] b = byteArrayBitmapStream.toByteArray();
            thumbnailBase64 = Base64.encodeToString(b, Base64.DEFAULT);
        }
    }

    public Bitmap getThumbnail(){
        if (thumbnail == null && thumbnailBase64 != null) {
            byte[] decodeString = Base64.decode(thumbnailBase64, Base64.DEFAULT);
            thumbnail = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);
        }
        return thumbnail;
    }

    //@Override
    public abstract Boolean isImportant();

    @Override
    public String toString() {
        // Some people thought they would be funny and add tweets without dates...
        if(date == null) {
            if(message == null) {
                return "";
            } else {
                return message;
            }
        }
        return date.toString() + " | " + message;
    }


    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }
}
