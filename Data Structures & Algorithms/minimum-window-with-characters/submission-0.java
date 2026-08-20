 class Solution {
        public String minWindow(String s, String t) {
            Map<Character,Integer> need = new HashMap<>();
            Map<Character,Integer> window = new HashMap<>();
            int have = 0;
            int left = 0;
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);

            }
            int needCount = need.size();
            int minLength = Integer.MAX_VALUE;
            int resultLeft = 0;
            for (int right =0 ; right < s.length(); right++) {
                char c = s.charAt(right);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        have++;
                    }
                }

                while ( have == needCount ) {
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        resultLeft = left;
                    }
                    char c2 = s.charAt(left);
                    if (need.containsKey(c2)) {
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                    if (window.get(c2) < need.get(c2)) {
                        have--;
                    }
                    }
                    left++;
                }
                }
            return minLength == Integer.MAX_VALUE ? "" : s.substring(resultLeft, resultLeft + minLength);
            }
        }
