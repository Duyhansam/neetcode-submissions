class Solution {
        public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int n = s2.length();
        if (len > n)  return false;
        int[] countS1 = new int[26];
        int [] countWindow = new int[26];
        for (int i =0; i < len; i++) {
        countS1[s1.charAt(i)-'a']++;
        countWindow[s2.charAt(i)-'a']++;
        }

        if (Arrays.equals(countWindow, countS1))
            return true;

        for (int i =1; i <= n - len; i++) {
            countWindow[s2.charAt(i +len -1)-'a']++;
            countWindow[s2.charAt(i -1)-'a']--;
            if (Arrays.equals(countWindow, countS1))
                return true;
        }
        return  false;
        }

    }
