package utils;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    /**
     * 层级建树
     *
     * @param list 层级遍历的list
     */
    public static TreeNode createTree(Deque<Integer> list) {
        TreeNode res = new TreeNode(list.removeFirst());

        List<TreeNode> queue = new LinkedList<>(Collections.singletonList(res));

        while (!list.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : queue) {

                node.left = createTreeByInteger(list.removeFirst());
                if (list.isEmpty()) break;

                node.right = createTreeByInteger(list.removeFirst());
                if (list.isEmpty()) break;

                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);

                queue = temp;
            }
        }
        return res;
    }

    private static TreeNode createTreeByInteger(Integer integer) {
        if (integer == null) return null;
        else return new TreeNode(integer);
    }
}
