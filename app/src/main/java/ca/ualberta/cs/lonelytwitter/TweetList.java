package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * The tweetlist is a object to contain an arraylist of tweets
 * <p>Created so that you may manipulate the arraylist of tweets easily.</p>
 * Created by jayden1 on 1/26/16.
 *
 * @author jayden1
 */
public class TweetList {
    private ArrayList<Tweet> tweets=new ArrayList<Tweet>();

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void addTweet(Tweet tweet) throws IllegalArgumentException{
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("Cant have duplicate tweets!");
        }
        tweets.add(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public int getCount(){
        return tweets.size();
    }

    /**
     * Returns a list in chronological order
     * <p>Chronological order has oldest FIRST</p>
     * @return the arraylist of tweets
     */
    public ArrayList<Tweet> getTweets(){
        //Get tweets in chronological order (most recent last)
        ArrayList<Tweet> clonedList = new ArrayList<Tweet>();

        for (int x = 0; x < tweets.size() ; x++){
            clonedList.add(tweets.get(x));
        }

        ArrayList<Tweet> returnlist = new ArrayList<Tweet>();
        int count = tweets.size();
        int smallestIndex = 0;

        while(count > 0){
            for (int i = 0; i < clonedList.size() ; i++) {
                if (tweets.get(smallestIndex).getDate().before(tweets.get(i).getDate())) {
                    //If the current tweet is newer than next tweet
                    //http://stackoverflow.com/questions/2592501/how-to-compare-dates-in-java
                    smallestIndex = i;
                }
            }
            count += -1;
            returnlist.add(clonedList.get(smallestIndex));
            clonedList.remove(smallestIndex);
        }

        return returnlist;
    }
}
