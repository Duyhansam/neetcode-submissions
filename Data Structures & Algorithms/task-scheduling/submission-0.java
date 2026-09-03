class Solution {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> map = new HashMap<>();
        public int leastInterval(char[] tasks, int n) {
            for(char c : tasks){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
           for (int count : map.values()){
               maxHeap.offer(count);
            }
            int time  = 0;
            while(!maxHeap.isEmpty()){
                List<Integer> temp= new ArrayList<>();
                for(int i = 0; i< n +1;i++){
                if (!maxHeap.isEmpty()){
                    int count = maxHeap.poll();
                    count --;
                    if(count > 0){
                        temp.add(count);
                    }
                }
                time++;
                if(temp.isEmpty() && maxHeap.isEmpty()){
                    break;
                }
                }
                for(int count : temp){
                    maxHeap.offer(count);
                }
            }
            return time;
        }
}
