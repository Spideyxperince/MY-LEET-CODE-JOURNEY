class Solution {
    public int lengthOfLongestSubstring(String s) {
        int rs = 0; int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();

        for (int right = 0; right < arr.length; right++) {
            int idx = map.containsKey(arr[right]) ? map.get(arr[right]) : -1;

            if (idx != -1 && idx >= left) {
                rs = Math.max(rs, right - 1 - left + 1);
                left = idx + 1;
            }

            map.put(arr[right], right);
        }

        rs = Math.max(rs, arr.length - 1 - left + 1);

        return rs;
    }
}