import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	private static int timeStamp=0;

	// easy to find if user exist
	private Map<Integer, User> userMap;

	// Tweet link to next Tweet so that we can save a lot of time
	// when we execute getNewsFeed(userId)
	private class Tweet{
		public int id;
		public int time;
		public Tweet next;

		public Tweet(int id){
			this.id = id;
			time = timeStamp++;
			next=null;
		}
	}


	// OO design so User can follow, unfollow and post itself
	public class User{
		public int id;
		public Set<Integer> followed;
		public Tweet tweet_head;

		public User(int id){
			this.id=id;
			followed = new HashSet<>();
			follow(id); // first follow itself
			tweet_head = null;
		}

		public void follow(int id){
			followed.add(id);
		}

		public void unfollow(int id){
			followed.remove(id);
		}


		// everytime user post a new tweet, add it to the head of tweet list.
		public void post(int id){
			Tweet t = new Tweet(id);
			t.next=tweet_head;
			tweet_head=t;
		}
	}




	/** Initialize your data structure here. */
	public Twitter() {
		userMap = new HashMap<Integer, User>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if(!userMap.containsKey(userId)){
			User u = new User(userId);
			userMap.put(userId, u);
		}
		userMap.get(userId).post(tweetId);

	}



	// Best part of this.
	// first get all tweets lists from one user including itself and all people it followed.
	// Second add all heads into a max heap. Every time we poll a tweet with 
	// largest time stamp from the heap, then we add its next tweet into the heap.
	// So after adding all heads we only need to add 9 tweets at most into this 
	// heap before we get the 10 most recent tweet.
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new LinkedList<>();

		if(!userMap.containsKey(userId))   return res;

		Set<Integer> users = userMap.get(userId).followed;
		PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
		for(int user: users){
			Tweet t = userMap.get(user).tweet_head;
			// very imporant! If we add null to the head we are screwed.
			if(t!=null){
				q.add(t);
			}
		}
		int n=0;
		while(!q.isEmpty() && n<10){
		  Tweet t = q.poll();
		  res.add(t.id);
		  n++;
		  if(t.next!=null)
			q.add(t.next);
		}

		return res;

	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId)){
			User u = new User(followerId);
			userMap.put(followerId, u);
		}
		if(!userMap.containsKey(followeeId)){
			User u = new User(followeeId);
			userMap.put(followeeId, u);
		}
		userMap.get(followerId).follow(followeeId);
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId) || followerId==followeeId)
			return;
		userMap.get(followerId).unfollow(followeeId);
	}

    public static void main(String[] args) {
        Twitter sol = new Twitter();
        sol.postTweet(1, 5);
        sol.getNewsFeed(1);
        sol.follow(1, 2);
        sol.postTweet(2, 6);
        sol.getNewsFeed(1);
        sol.unfollow(1, 2);
        sol.getNewsFeed(1);
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

 /*abstract

355. Design Twitter
Medium

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.

 */