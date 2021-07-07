package company.didi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/07/06 20:38:23
 * jdk自带的排序
 */
public class ComparatorSort {
    static class User {
        Integer id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private void sort(List<User> list) {
        list.sort((o1, o2) -> {
            if (o1.id != null && o2.id != null) {
                return o2.id - o1.id;
            }
            if (o1.id == null && o2.id == null) {
                return 0;
            }
            return 1;
        });
    }

    public static void main(String[] args) {
        User u1 = new User(1, "a");

        List<User> list = new ArrayList<>();
        list.add(u1);
    }
}
