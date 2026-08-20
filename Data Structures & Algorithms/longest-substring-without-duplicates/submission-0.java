class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int maxchar=0;
            HashSet<Character> set = new HashSet<>();
            for (int right=0; right<s.length(); right++) {
            while (left < s.length() && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxchar = Math.max(maxchar, set.size());
            }
            return maxchar;
        }
    }
