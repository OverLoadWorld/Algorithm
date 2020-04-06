package ThirtyDays.week1;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Arrays.deepToString(groupAnagrams(strs).toArray()));
    }

    /**
     * Runtime: 23 ms
     * Memory Usage: 53.1 MB
     * Your runtime beats 12.47 % of java submissions.
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String code = calculateCode(str);
            if (map.containsKey(code)) {
                List<String> stringList = map.get(code);
                stringList.add(str);
            } else {
                List<String> stringList = new ArrayList<>(1);
                stringList.add(str);
                map.put(code, stringList);
            }
        }
        List<List<String>> ret = new ArrayList<>();
        for (List<String> stringList : map.values()) {
            ret.add(stringList);
        }
        return ret;
    }

    private static String calculateCode(String str) {
        int[] codeArr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            codeArr[i] = str.charAt(i);
        }
        Arrays.sort(codeArr);
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < codeArr.length; i++) {
            code.append(codeArr[i]);
        }
        return code.toString();
    }
}
