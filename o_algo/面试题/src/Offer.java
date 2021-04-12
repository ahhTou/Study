import utils.TreeNode;

import java.util.*;

public class Offer {

    /*
     * 剑指 Offer 50. 第一个只出现一次的字符
     * */
    public char firstUniqChar(String s) {
        if (s.equals("")) return ' ';

        // 创建 a-z 的字典
        int[] target = new int[26];

        for (int i = 0; i < s.length(); i++) {
            target[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (target[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }

        return ' ';

    }


    /**
     * 二分法 剑指 Offer 53 - I. 在排序数组中查找数字 I
     */
    public int search(int[] nums, int target) {
/*        int count = 0;

        for (int num : nums) {
            if (num == target) count++;
            else if (count > 0) break;
        }

        return count; */
/*        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;

        if (j >= 0 && nums[j] != target) return 0;

        i = 0;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;

        return right - left - 1;*/

        int i = 0, j = nums.length - 1, m;
        while (i <= j) {
            m = (i + j) / 2;
            if (nums[m] >= target) j = m - 1;
            else i = m + 1;
        }
        if (j + 1 == nums.length || nums[j + 1] != target) return 0;

        int left = j;

        i = nums.length - 1;
        while (j <= i) {
            m = (i + j) / 2;
            if (nums[m] > target) i = m - 1;
            else j = m + 1;

        }

        int right = j;


        return right - left - 1;
    }

    /**
     * 二分法 剑指 Offer 53 - II. 0～n-1中缺失的数字
     */
    public int missingNumber(int[] nums) {

        int i = 0, j = nums.length - 1;
        while (i != j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m;
        }
        return nums[i] == i ? nums[i] + 1 : nums[i] - 1;
    }


    /**
     * 剑指 Offer 55 - I. 二叉树的深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>(Collections.singletonList(root));
        int res = 0;

        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.right != null) temp.add(node.right);
                if (node.left != null) temp.add(node.left);
            }
            queue = temp;
            res++;
        }

        return res;
    }

    /**
     * 剑指 Offer 55 - II. 平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        return isBalanced_helper(root) != -1;
    }

    public int isBalanced_helper(TreeNode root) {
        if (root == null) return 0;
        int left = isBalanced_helper(root.left);
        if (left == -1) return -1;
        int right = isBalanced_helper(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right) + 1;
    }

    /*
     * 剑指 Offer 61. 扑克牌中的顺子
     */
    public boolean isStraight(int[] nums) {
        int[] set = new int[14];
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            set[num - 1]++;
            if (set[num - 1] > 1) return false;
        }

        return max - min < 5;
    }

    /**
     * 滑动窗口 剑指 Offer 57 - II. 和为s的连续正数序列
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1, j = 2, total = 3;

        while (i < j) {
            if (total < target) {
                j++;
                total += j;
            } else if (total > target) {
                total -= i;
                i++;
            } else {
                int[] temp = new int[j - i + 1];
                for (int k = i; k <= j; k++) temp[k - i] = k;
                res.add(temp);
                total -= i;
                i++;
            }
        }

        return res.toArray(new int[0][]);
    }

    /**
     * 单调队列 剑指 Offer 59 - I. 滑动窗口的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // 形成窗口 前
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }

        res[0] = deque.peekFirst();
        System.out.println("deque is" + deque);

        // 形成窗口 后
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == deque.peekFirst()) deque.removeFirst(); // 如果队列头是滑走的，则去除头

            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(nums[i]);

            res[i - k + 1] = deque.peekFirst();
        }

        return res;
    }


    /*
     * 剑指 Offer 62. 圆圈中最后剩下的数字 使用模拟法
     */
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }

        return list.get(0);
    }

    /*
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (
                    root.val < p.val && root.val < q.val
            ) {
                root = root.right;
            } else if (
                    root.val > p.val && root.val > q.val
            ) {
                root = root.left;
            } else return root;
        }
        return root;
    }

    /**
     * 递归操作 剑指 Offer 68 - II. 二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root; // 找到其中一个节点，直接返回该节点

        TreeNode res_left = lowestCommonAncestor(root.left, p, q);
        TreeNode res_right = lowestCommonAncestor(root.right, p, q);

        if (res_left != null && res_right != null) return root; // p q 一个在左，一个在右

        if (res_left != null) return res_left; // p q 都在左子树

        return res_right;// p q 都在右子树 时候返回res_right节点 否则返回null
    }


}
