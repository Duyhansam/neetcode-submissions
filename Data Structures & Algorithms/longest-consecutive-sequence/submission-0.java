class Solution {
    public int longestConsecutive(int[] nums) {
         HashSet<Integer> set = new HashSet<>();
            int maxLength = 0;
            for (int x : nums) {
                set.add(x);
            }
            for (int x : nums) {
                if (!set.contains(x - 1)) {
                    int length = 1;
                    int num = x+1;
                    while (set.contains(num)) {
                        num++;
                        length++;
                    }
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
            return maxLength;
    }
}
