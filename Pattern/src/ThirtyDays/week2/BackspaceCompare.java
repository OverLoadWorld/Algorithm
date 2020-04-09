package ThirtyDays.week2;

public class BackspaceCompare {
    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        String S1 = "ab##";
        String T1 = "c#d#";
        String S2 = "a##c";
        String T2 = "#a#c";
        String S3 = "a#c";
        String T3 = "b";
        System.out.println(backspaceCompare(S, T));
        System.out.println(backspaceCompare(S1, T1));
        System.out.println(backspaceCompare(S2, T2));
        System.out.println(backspaceCompare(S3, T3));
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 37.4 MB
     * Your runtime beats 100.00 % of java submissions.
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare(String S, String T) {
        char[]sChar = S.toCharArray();
        char[]tChar = T.toCharArray();
        int sIndex = 0;
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != '#') {
                sChar[sIndex++] = sChar[i];
            } else {
                if(sIndex > 0) sIndex--;
                sChar[sIndex] = 0;
            }
        }
        int tIndex = 0;
        for (int i = 0; i < tChar.length; i++) {
            if (tChar[i] != '#') {
                tChar[tIndex++] = tChar[i];
            } else {
                if(tIndex > 0) tIndex--;
                tChar[tIndex] = 0;
            }
        }
        if (sIndex != tIndex) {
            return false;
        }
        for (int i = 0; i < tIndex; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }
}
