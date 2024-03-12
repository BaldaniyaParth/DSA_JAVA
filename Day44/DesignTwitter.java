package Day44;

import java.util.*;

public class DesignTwitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // Example usage
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 10);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.postTweet(2, 7);

        List<Integer> newsFeed = twitter.getNewsFeed(1);
        System.out.println("News Feed for user 1: " + newsFeed);

        twitter.unfollow(1, 2);
        newsFeed = twitter.getNewsFeed(1);
        System.out.println("After unfollowing user 2, News Feed for user 1: " + newsFeed);

    }
}

class Twitter {

    Map<Integer, Set<Integer>> userFollowersMap;
    Deque<int[]> arrayDeque;

    public Twitter() {
        userFollowersMap = new HashMap<>();
        arrayDeque = new ArrayDeque<>();
    }

    public void postTweet(int userId, int tweetId) {
        arrayDeque.addFirst(new int[]{userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> currentUserFollowingPeople = userFollowersMap.getOrDefault(userId, new HashSet<Integer>());
        Iterator<int[]> iterator = arrayDeque.iterator();
        List<Integer> tweetsThatShouldShowUpInTheGivenUserFeed = new ArrayList<>();
        while (iterator.hasNext()) {
            int[] entry = iterator.next();
            if (currentUserFollowingPeople.contains(entry[0]) || entry[0] == userId) {
                tweetsThatShouldShowUpInTheGivenUserFeed.add(entry[1]);
            }

            if (tweetsThatShouldShowUpInTheGivenUserFeed.size() == 10) {
                return tweetsThatShouldShowUpInTheGivenUserFeed;
            }
        }
        return tweetsThatShouldShowUpInTheGivenUserFeed;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> iamFollowing;
        if (userFollowersMap.containsKey(followerId)) {
            iamFollowing = userFollowersMap.get(followerId);
        } else {
            iamFollowing = new HashSet<>();
        }
        iamFollowing.add(followeeId);
        userFollowersMap.put(followerId, iamFollowing);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollowersMap.containsKey(followerId)) {
            Set<Integer> followeeIds = userFollowersMap.get(followerId);
            followeeIds.remove(followeeId);
            userFollowersMap.put(followerId, followeeIds);
        }
    }
}