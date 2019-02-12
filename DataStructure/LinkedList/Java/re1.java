import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 howard
 * @Date: 18-12-25 下午6:54
 */
public class re1 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            sb.append("1 6 10 4 2 3 8 3 3 7 9 1 4 5 6 2");
        }
        long t1 = System.currentTimeMillis();
        System.out.println(solution(sb.toString()));
        System.out.println(System.currentTimeMillis() - t1);

    }

    /**
     * 已引入：
     * java.util.*
     * 要使用其他 jar 包请使用完整路径，如：
     * java.util.List<java.util.List<Integer>> list = new java.util.ArrayList<java.util.List<Integer>>(100);
     * @param  line 为单行测试数据
     * @return 处理后的结果
     */
    private static String solution1(String line) {
        // please write your code here
        String[] items = line.split(" ");
        List<HashMap<String, Object>> list = new ArrayList<>(10000000);
        int index = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        while (items.length > index) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("a", items[index + 1]);
            if (min > Long.valueOf(items[index + 1])) {
                min = Long.valueOf(items[index + 1]);
            }

            map.put("b", items[index + 2]);
            if (max < Long.valueOf(items[index + 2])) {
                max = Long.valueOf(items[index + 2]);
            }

            map.put("s", items[index + 3]);
            list.add(map);

            index += 4;
        }

        long result = 0L;

        for (long i = min; i < max; i++) {
            Iterator<HashMap<String, Object>> iterator = list.iterator();
            long momentScore = 0L;
            while (iterator.hasNext()) {
                HashMap<String, Object> next =  iterator.next();
                long moStart = Long.valueOf((String) next.get("a"));
                long moEnd = Long.valueOf((String) next.get("b"));
                if(i >= moStart
                        && i < moEnd){
                    momentScore += Long.valueOf((String) next.get("s"));
                }
                if (moEnd < i) {
                    iterator.remove();
                }
            }
            if (momentScore > result) {
                result = momentScore;
            }
        }



        // return ans;
        return result + "";
    }

    private static String solution2(String line) {
        // please write your code here
        String[] items = line.split(" ");
        List<String> list = new ArrayList<>(10000000);
        int index = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        while (items.length > index) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 6 - items[index + 1].length(); i++) {
                sb.append("0");
            }
            sb.append(items[index + 1]);


            for (int i = 0; i < 6 - items[index + 2].length(); i++) {
                sb.append("0");
            }
            sb.append(items[index + 2]);


            for (int i = 0; i < 6 - items[index + 3].length(); i++) {
                sb.append("0");
            }
            sb.append(items[index + 3]);

            if (min > Long.valueOf(items[index + 1])) {
                min = Long.valueOf(items[index + 1]);
            }

            if (max < Long.valueOf(items[index + 2])) {
                max = Long.valueOf(items[index + 2]);
            }

            list.add(sb.toString());

            index += 4;
        }



        long result = 0L;


        for (long i = min; i < max; i++) {
            Iterator<String> iterator = list.iterator();
            long momentScore = 0L;
            while (iterator.hasNext()) {
                String next =  iterator.next();
                long moStart = Long.valueOf(next.substring(0,6));
                long moEnd = Long.valueOf(next.substring(6,12));
                if(i >= moStart
                        && i < moEnd){
                    momentScore += Long.valueOf(next.substring(12,18));
                }
                if (moEnd < i) {
                    iterator.remove();
                }
            }
            if (momentScore > result) {
                result = momentScore;
            }
        }


        // return ans;
        return result + "";
    }

    private static String solution(String line) {
        // please write your code here
        String[] items = line.split(" ");
        List<String> list = new ArrayList<>(10000000);
        int index = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (items.length > index) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 6 - items[index + 1].length(); i++) {
                sb.append("0");
            }
            sb.append(items[index + 1]);


            for (int i = 0; i < 6 - items[index + 2].length(); i++) {
                sb.append("0");
            }
            sb.append(items[index + 2]);


            for (int i = 0; i < 6 - items[index + 3].length(); i++) {
                sb.append("0");
            }
            sb.append(items[index + 3]);

            if (min > Integer.valueOf(items[index + 1])) {
                min = Integer.valueOf(items[index + 1]);
            }

            if (max < Integer.valueOf(items[index + 2])) {
                max = Integer.valueOf(items[index + 2]);
            }

            list.add(sb.toString());

            index += 4;
        }



        Iterator<String> iterator = list.iterator();
//        List<Long> retRecordList = new ArrayList<>(max);
        long[] retRecordList = new long[max];
        while (iterator.hasNext()) {
            String next = iterator.next();
            int moStart = Integer.valueOf(next.substring(0, 6));
            int moEnd = Integer.valueOf(next.substring(6, 12));
            for (int i = moStart; i < moEnd; i++) {
                retRecordList[i] += Long.valueOf(next.substring(12, 18));
            }

        }
        long result = 0L;

        for (int i = 0; i < retRecordList.length; i++) {
            long l = retRecordList[i];
            if (l > result) {
                result = l;
            }
        }

        // return ans;
        return result + "";
    }
}
