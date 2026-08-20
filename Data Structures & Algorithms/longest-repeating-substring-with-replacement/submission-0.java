class Solution {
        public int characterReplacement(String s, int k) {
        int [] count = new int[26];
        int left = 0;
        int maxLen = 0;
        int maxFreq =0;

        for(int right = 0; right < s.length(); right++){
                int index = s.charAt(right) - 'A';
                count[index]++;
                maxFreq = Math.max(maxFreq,count[index]);
            while ((right - left +1) - maxFreq > k ){
                int indexl = s.charAt(left) - 'A';
                count[indexl]--;
                left++;
            }
                maxLen = Math.max(maxLen,right - left + 1);
        }
        return maxLen;
        }
    }
