package simple.phase1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/09/24 11:22:30
 */
public class Number108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(0, nums.length - 1, nums);
    }

    public TreeNode recursion(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        //去数组中间或紧靠中间左右两边的数
        int middle = (left + right) / 2;
        //根节点
        TreeNode root = new TreeNode(nums[middle]);
        //左子树
        root.left = recursion(left, middle - 1, nums);
        //右子树
        root.right = recursion(middle + 1, right, nums);
        return root;
    }


    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        if (nums.length == 2) {
            TreeNode root = new TreeNode(nums[1]);
            root.left = new TreeNode(nums[0]);
            return root;
        }

        int length = nums.length;
        int halfLength = length / 2;
        //找到根节点
        TreeNode root = new TreeNode(0);
        root.val = nums[halfLength];

        //左子树
        int[] leftNums = new int[halfLength];
        System.arraycopy(nums, 0, leftNums, 0, halfLength);
        root.left = sortedArrayToBST2(leftNums);

        //右子树
        int[] rigthNums = new int[length - halfLength - 1];
        System.arraycopy(nums, halfLength + 1, rigthNums, 0, length - halfLength - 1);
        root.right = sortedArrayToBST2(rigthNums);
        return root;
    }


    public static void main(String[] args) {
        int[] a = {-10, -3, 0, 5, 9};
        new Number108().sortedArrayToBST2(a);
    }
}
