class Solution {
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        public int lastStoneWeight(int[] stones) {
         for (int num : stones) {
             maxHeap.offer(num);
         }
         while (maxHeap.size() > 1){
             int num1 = maxHeap.poll();
             int num2 = maxHeap.poll();
             if (num1 - num2 > 0) {
                 maxHeap.offer(num1 - num2);
             }
         }
         if (maxHeap.isEmpty()){
             return 0;
         }
         return maxHeap.peek();
        }
    }
