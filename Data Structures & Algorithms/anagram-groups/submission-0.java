class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String ss = new String(s);
            if (!map.containsKey(ss)) {
                map.put(ss, new ArrayList<String>());
            }
            map.get(ss).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}