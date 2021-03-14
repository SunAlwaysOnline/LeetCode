package leetcode.medium.phase4;

import method.Classic;
import method.Design;
import util.ListUtil;

import java.util.*;

/**
 * @author qcy
 * @create 2021/03/14 11:30:49
 * 355. 设计推特
 *
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。
 * 你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Design
public class Number355 {

    static class Twitter {
        //发送者:推特集合
        Map<Integer, Set<Integer>> tweetMap;
        //用户:关注的人集合
        Map<Integer, Set<Integer>> relationMap;
        //推特id:编号
        Map<Integer, Integer> numberMap;

        public Twitter() {
            tweetMap = new HashMap<>();
            relationMap = new HashMap<>();
            numberMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            Set<Integer> set = tweetMap.getOrDefault(userId, new HashSet<>());
            set.add(tweetId);
            tweetMap.put(userId, set);
            numberMap.put(tweetId, numberMap.size());
        }


        public List<Integer> getNewsFeed(int userId) {
            //获取关注的人
            Set<Integer> set = relationMap.getOrDefault(userId, new HashSet<>());
            set.add(userId);

            Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> numberMap.get(a)));
            for (Integer key : set) {
                Set<Integer> tweets = tweetMap.get(key);
                if (tweets == null || tweets.size() == 0) {
                    continue;
                }
                for (Integer id : tweets) {
                    if (queue.size() < 10) {
                        queue.offer(id);
                        continue;
                    }
                    if (numberMap.get(queue.peek()) < numberMap.get(id)) {
                        queue.poll();
                        queue.offer(id);
                    }
                }
            }

            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            Collections.reverse(list);
            return list;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> set = relationMap.getOrDefault(followerId, new HashSet<>());
            set.add(followeeId);
            relationMap.put(followerId, set);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> set = relationMap.getOrDefault(followerId, new HashSet<>());
            set.remove(followeeId);
            relationMap.put(followerId, set);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        List<Integer> feed = twitter.getNewsFeed(1);
        ListUtil.print(feed);

    }
}
