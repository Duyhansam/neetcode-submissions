class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int s =0;
            int max = 0;

            for (int i = 0; i <= heights.length; i++) {
            int a = (i == heights.length ? 0 : heights[i]);
                while (!stack.empty() && a < heights[stack.peek()]) {
                      int h = heights[stack.pop()];
                      int w = i -(stack.empty() ? -1 : stack.peek())-1;
                         s = h * w;
                      max = Math.max(max, s);
                }
                stack.push(i);
            }
            return max;
        }
    }
