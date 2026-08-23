class Solution {
    public int findDuplicate(int[] nums) {
          int slow = nums[0];
        int fast = nums[0];
        for (int i = 1; i < nums.length; i++) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
break;            }
        }
        int ptr = nums[0];
        while (ptr != slow) {
            slow = nums[slow];
            ptr  = nums[ptr];
            if (slow == ptr) {
                return ptr;
            }
        }
        return  ptr;
    }
}
