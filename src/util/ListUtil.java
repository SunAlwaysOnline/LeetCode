package util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qcy
 * @create 2021/01/29 17:19:47
 */
public class ListUtil {

    public static <T> void print(List<T> list) {
        String str = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(str);
    }

    public static <T> void printOut(List<List<T>> out) {
        out.forEach(ListUtil::print);
    }

    public static void main(String[] args) {
    }
}
