package leetcode.simple.phase8;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author qcy
 * @create 2020/10/02 11:43:04
 */
public class Number771 {

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0) {
            return 0;
        }
        if (S == null || S.length() == 0) {
            return 0;
        }

        int sum = 0;
        int jLength = J.length();
        int sLength = S.length();

        for (int j = 0; j < jLength; j++) {
            char c = J.charAt(j);
            for (int s = 0; s < sLength; s++) {
                if (S.charAt(s) == c) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAb";
        System.out.println(new Number771().numJewelsInStones(j, s));
    }
}
