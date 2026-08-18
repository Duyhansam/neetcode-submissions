class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int right = 0;
        for (int i =0 ; i < piles.length; i++){
            if (piles[i] > right){
                right = piles[i];
            }
            }
        int left = 1;
        while (left < right){
            int mid = left + (right - left) / 2;
             if (getHours(piles, mid) <= h){
                right = mid;
            } else {
                left = mid + 1;
             }
        }
        return left;

    }
}
    private int getHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours;
    }
