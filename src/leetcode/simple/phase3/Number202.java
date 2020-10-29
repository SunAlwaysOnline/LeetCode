package leetcode.simple.phase3;

/**
 * @author qcy
 * @create 2020/10/29 20:05:55
 */
public class Number202 {

    public boolean isHappy(int n) {
        if (n == 1 || isTenPower(n)) {
            return true;
        }
        int result = 0;
        int oddCount = 0;
        while (n != 0) {
            int cur = n % 10;
            if (cur % 2 == 1) {
                oddCount++;
            }
            n = n / 10;
            result += cur * cur;
        }
        if (oddCount % 2 == 1) {
            return false;
        }

        return isHappy(result);
    }

    private boolean isTenPower(int n) {
        while (n != 0) {
            if (n >= 10 && n % 10 != 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 19;
        Number202 main = new Number202();
        System.out.println(main.isHappy(100));
    }

}
