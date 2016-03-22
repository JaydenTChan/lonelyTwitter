package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by Ian on 22/03/2016.
 */
public class TweetList {
    private final ArrayList<Tweet> tweets; //Changed to be private and final

    public TweetList(){
        tweets = new ArrayList<Tweet>();
    }

    public TweetList(ArrayList<Tweet> t){
        tweets = t;
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void addNewTweet(Tweet tweet){
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public int countImportant(){
        int numImportant = 0;
        for (Tweet aTweet:this.tweets){
            if(aTweet.isImportant() == Boolean.TRUE){
                numImportant++;
            }
        }
        return numImportant;
    }

}
