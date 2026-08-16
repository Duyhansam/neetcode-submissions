class Solution {
        public int maxArea(int[] heights) {
            int maxwater = 0;
            int left = 0;
            int right = heights .length - 1;
            while (left < right) {
                int water = (right - left) * Math.min(heights    [left], heights [right]);

                if (water > maxwater) {
                    maxwater = water;
                }
                if (heights [left] < heights    [right]) {
                    left++;

                } else {
                    right--;
                }
            }
           return maxwater;
        }
    }
