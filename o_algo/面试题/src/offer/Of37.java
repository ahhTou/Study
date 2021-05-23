package offer;

import utils.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 37. 序列化二叉树
 */
public class Of37 {
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> deque = new LinkedList<>(Collections.singletonList(root));
        StringBuilder res = new StringBuilder("[");

        while (deque.size() > 0) {
            Deque<TreeNode> temp = new LinkedList<>();
            while (deque.size() > 0) {
                TreeNode treeNode = deque.removeFirst();
                if (treeNode != null) {
                    res.append(treeNode.val).append(",");
                    temp.addLast(treeNode.left);
                    temp.addLast(treeNode.right);
                } else {
                    res.append("null,");
                }
            }

            deque = temp;
        }

        if (res.charAt(res.length() - 1) == ',')
            res.deleteCharAt(res.length() - 1);
        return res.append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) return null;
        int s = 0;

        String[] split = data.substring(1, data.length() - 1)
                .replace(" ", "").split(",");

        TreeNode head = new TreeNode(Integer.parseInt(split[s++]));

        Deque<TreeNode> line = new LinkedList<>(Collections.singletonList(head));

        while (line.size() > 0) {
            Deque<TreeNode> temp = new LinkedList<>();
            while (line.size() > 0) {
                TreeNode node = line.removeFirst();
                if (node == null) continue;
                if (s < split.length) {
                    node.left = !split[s].equals("null") ? new TreeNode(Integer.parseInt(split[s])) : null;
                    s++;
                    temp.addLast(node.left);
                }

                if (s < split.length) {
                    node.right = !split[s].equals("null") ? new TreeNode(Integer.parseInt(split[s])) : null;
                    s++;
                    temp.addLast(node.right);
                }
            }
            line = temp;
        }

        return head;
    }

    public static void main(String[] args) {

        System.out.println("========");
        Of37 offer = new Of37();
        String goal = "[5,2,3,null,null,2,4,3,1]";
        System.out.println(goal);
        TreeNode deserialize = offer.deserialize(goal);

        String serialize = offer.serialize(deserialize);
        System.out.println(serialize);


    }

    public TreeNode deserialize_(String data) {
        if (data == null || data.length() <= 2) return null;

        String[] split = data.substring(1, data.length() - 1)
                .replace(" ", "").split(",");

        Deque<Integer> ints = new LinkedList<>();

        for (String s : split) ints.addLast(s.equals("null") ? null : Integer.parseInt(s));

        TreeNode head = new TreeNode(ints.removeFirst());

        Deque<TreeNode> line = new LinkedList<>(Collections.singletonList(head));

        while (line.size() > 0) {
            Deque<TreeNode> temp = new LinkedList<>();
            while (line.size() > 0) {
                TreeNode node = line.removeFirst();

                if (node == null) continue;

                if (ints.size() > 0) {
                    node.left = ints.peekFirst() != null ? new TreeNode(ints.peekFirst()) : null;
                    temp.addLast(node.left);
                    ints.removeFirst();
                }

                if (ints.size() > 0) {
                    node.right = ints.peekFirst() != null ? new TreeNode(ints.peekFirst()) : null;
                    temp.addLast(node.right);
                    ints.removeFirst();
                }
            }
            line = temp;
        }

        return head;
    }
}
