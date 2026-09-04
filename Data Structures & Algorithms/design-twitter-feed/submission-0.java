class Twitter {
        HashMap<Integer, Set<Integer>> following = new HashMap<>();
        HashMap<Integer, List<int[]>> tweets = new HashMap<>();
        int timestmap =0;

        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
        timestmap++;
        if (!tweets.containsKey(userId)) {
          List<int[]> news =  new ArrayList<>();
        tweets.put(userId, news);
        }
        List<int[]> res =  tweets.get(userId);
        res.add(new int[]{timestmap,tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
        Set<Integer> check = new HashSet<>();
        check.add(userId);
        if (following.containsKey(userId)) {
            check.addAll(following.get(userId));
        }
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int vl : check) {
            if ((tweets.containsKey(vl)) && !tweets.get(vl).isEmpty()) {
                List<int[]> news = tweets.get(vl);
                int lastindex = tweets.get(vl).size()-1;
                int[] last = news.get(lastindex);
                maxHeap.add(new int[]{last[0],last[1], vl, lastindex});
            }
        }
            List<Integer> res = new ArrayList<>();
            while ( res.size() < 10 && !maxHeap.isEmpty() ) {
                int[] max = maxHeap.poll();
                res.add(max[1]);
                int max2 = max[2];
                int max3 = max[3];
                if (max3 - 1 >=0){
                    int[] next = tweets.get(max[2]).get(max3 - 1);
                    maxHeap.offer(new int []{ next[0],next[1], max2,max3-1});
                }
            }

        return res;
        }

        public void follow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            Set<Integer> set = new HashSet<>();
        following.put(followerId, set);
        }
            following.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
        }
    }
