package leetcode.medium.phase3;

import method.Classic;
import method.Sort;

import java.util.*;

/**
 * @author qcy
 * @create 2021/03/22 15:33:07
 * 207. 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。
 * 这是不可能的。
 *  
 *
 * 提示：
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number207 {

    @Sort(way = "topology")
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int length = prerequisites.length;
        if (length == 0) {
            return true;
        }

        //入度数组
        int[] inDegree = new int[numCourses];
        //所有依赖于k的结点存放于v中
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] array : prerequisites) {
            inDegree[array[0]]++;
            map.computeIfAbsent(array[1], k -> new ArrayList<>()).add(array[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer val = queue.poll();
            numCourses--;
            List<Integer> list = map.getOrDefault(val, new ArrayList<>());
            for (Integer i : list) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return numCourses == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Number207().canFinish(2, new int[][]{{0, 1}}));
    }

}
