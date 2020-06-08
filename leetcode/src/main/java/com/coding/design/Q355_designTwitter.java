package com.coding.design;

import java.util.*;


public class Q355_designTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        List<Integer> newsFeed = null;

// User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
        newsFeed = twitter.getNewsFeed(1);
        printFeed(newsFeed);

// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        newsFeed = twitter.getNewsFeed(1);
        printFeed(newsFeed);

// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        newsFeed = twitter.getNewsFeed(1);
        printFeed(newsFeed);
    }

    private static void printFeed(List<Integer> newsFeed) {
       for (Integer feed : newsFeed){
           System.out.print(feed + ", ");
       }
        System.out.println();
    }
}

class Twitter {

    private int time;
    private HashMap<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        this.time = 0;
        this.userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!isValid(userId)){
            this.userMap.put(userId, new User(userId));
        }
        User user = this.userMap.get(userId);
        Tweet tweet = new Tweet(tweetId, this.time++);
        user.addTweet(tweet);
        this.userMap.put(userId, user);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!this.userMap.containsKey(userId))
            return new LinkedList<>();

        User user = this.userMap.get(userId);
        List<Tweet> tweets = getTweets(user);
        sort(tweets);
        List<Integer> result = new LinkedList<>();
        int count = tweets.size() > 10 ? 10 : tweets.size();
        for(int i=0; i<count; i++){
            result.add(tweets.get(i).id);
        }
        return result;
    }

    private void sort(final List<Tweet> tweets) {
        Collections.sort(tweets, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.time - o1.time;
            }
        });
    }

    private List<Tweet> getTweets(User user) {
        List<Tweet> tweetList = new LinkedList<>();
        tweetList.addAll(user.tweets);
        for (User u : user.followeeSet) {
            tweetList.addAll(u.tweets);
        }
        return tweetList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;

        if(!isValid(followerId)){
            this.userMap.put(followerId, new User(followerId));
        }

        if (!isValid(followeeId)){
            this.userMap.put(followeeId, new User(followeeId));
        }

        User follower = this.userMap.get(followerId);
        User followee = this.userMap.get(followeeId);
        follower.addFollowee(followee);
    }

    private boolean isValid(int fId) {
        return this.userMap.containsKey(fId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!(isValid(followerId) && isValid(followeeId)))
            return;

        User follower = this.userMap.get(followerId);
        User followee = this.userMap.get(followeeId);
        follower.unfollow(followee);
    }

    class User {
        int id;
        Set<User> followeeSet;
        List<Tweet> tweets;

        public User(int id){
            this.id = id;
            this.followeeSet = new HashSet<>();
            this.tweets = new LinkedList<>();
        }

        public void addFollowee(User user){
            this.followeeSet.add(user);
        }

        public void addTweet(Tweet tweet){
            this.tweets.add(tweet);
        }

        public void unfollow(User followee) {
            this.followeeSet.remove(followee);
        }
    }

    class Tweet {
        int id;
        int time;

        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */