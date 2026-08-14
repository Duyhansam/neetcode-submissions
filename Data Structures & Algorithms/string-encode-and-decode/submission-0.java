class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
           for (String s  : strs) {
               sb.append(s.length()).append("#").append(s);
           }
           return sb.toString();
    }

    public List<String> decode(String str) {
         List<String> lst = new ArrayList<>();
        int i =0;
        while (i< str.length()) {
          int j = str.indexOf("#", i);
          int num = Integer.parseInt(str.substring(i, j));
          String s = str.substring(j+1,num+j+1);
          lst.add(s);
          i = j + 1 + num;

            }
        return lst;
    }
}
