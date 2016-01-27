package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jayden1 on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        //tweets.addTweet(tweet);

        //Test duplicate tweets throwing IllegalArgumentException
        try{
            tweets.addTweet(tweet);
        }catch (IllegalArgumentException a){
            // Illegal Exception
        }

    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweets.hasTweet(tweet));

        tweets.addTweet(tweet);
        tweets.hasTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));

    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        tweets.removeTweet(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());

    }

    public void testGetTweets(){
        //Expected Test tweet2, Test tweet1, Test tweet
        TweetList tweets = new TweetList();

        ArrayList<Tweet> tweetCompare = new ArrayList<Tweet>();

        Tweet tweet = new NormalTweet("Test tweet");
        Tweet tweet1 = new NormalTweet("Test tweet1");
        Tweet tweet2 = new NormalTweet("Test tweet2");
        tweets.addTweet(tweet);
        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);

        tweetCompare.add(tweet);
        tweetCompare.add(tweet1);
        tweetCompare.add(tweet2);

        assertEquals(tweetCompare,tweets.getTweets());

    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        Tweet tweet1 = new NormalTweet("Test tweet1");
        Tweet tweet2 = new NormalTweet("Test tweet2");

        //Assert that getCount counts up properly
        assertTrue(0 == tweets.getCount());
        tweets.addTweet(tweet);
        assertTrue(1 == tweets.getCount());
        tweets.addTweet(tweet1);
        assertTrue(2 == tweets.getCount());
        tweets.addTweet(tweet2);
        assertTrue(3 == tweets.getCount());

    }

}
