class Solution {
     private PriorityQueue<Integer> minHeap;
        int k;
        public int findKthLargest(int[] nums, int k) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int i : nums) {
            addVal(i);
        }
        return minHeap.peek();
        }
        private void addVal(int val) {
            minHeap.offer(val);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
}
