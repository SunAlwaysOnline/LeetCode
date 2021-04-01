package leetcode.hard.phase5;

import method.WaitForComplete;

import java.util.List;

/**
 * @author qcy
 * @create 2021/04/01 10:01:28
 */
@WaitForComplete
public class Number428 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

//    class Codec {
//
//        public String serialize(Node root) {
//            if (root == null) {
//                return "";
//            }
//            StringBuilder sb=new StringBuilder();
//            Queue<Node> queue=new LinkedList<>();
//            queue.offer(root);
//
//            while (!queue.isEmpty()){
//                Node node=queue.poll();
//                if (node==null){
//                    sb.append("null").append(",");
//                    continue;
//                }
//                sb.append(node.val).append(",");
//                for(Node n:node.children){
//                    sb.append("")
//                }
//                sb.append()
//            }
//        }
//
//        public Node deserialize(String data) {
//            if (data.equals("")) {
//                return null;
//            }
//        }
//
//    }

}
