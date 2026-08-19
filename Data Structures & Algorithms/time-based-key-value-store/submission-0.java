 class TimeMap {
        HashMap <String, List<Integer>> timestampMap;
        HashMap <String, List<String>> valueMap;

        public TimeMap() {
        timestampMap = new HashMap <>();
        valueMap = new HashMap <>();
        }

        public void set(String key, String value, int timestamp) {
        if(!timestampMap.containsKey(key)){
            timestampMap.put(key,new ArrayList<>());
            valueMap.put(key,new ArrayList<>());
        }
        timestampMap.get(key).add(timestamp);
        valueMap.get(key).add(value);
        }

        public String get(String key, int timestamp) {
        if (!timestampMap.containsKey(key)) {
            return "";
        }
        List<Integer> timestamps = timestampMap.get(key);
        List<String> values = valueMap.get(key);

        int left =0;
        int right = timestamps.size()-1;
        String result = "";
        while(left<=right){
            int mid = left+ (right - left)/2;
             if (timestamps.get(mid) <= timestamp){
                 result = values.get(mid);
                 left=mid+1;
             } else if (timestamps.get(mid) > timestamp) {
                 right = mid - 1;

             }


        }
        return result;
        }
    }
