import com.sun.org.apache.bcel.internal.generic.FADD;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import sun.security.krb5.internal.PAData;
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

    /*
     * 剑指 Offer 26. 树的子结构
     * */
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) return false;

        if (a.val == b.val && isSubStructure_helper(a, b)) return true;

        return isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    public boolean isSubStructure_helper(TreeNode a, TreeNode b) {
        if (b == null) return true;

        if (a == null) return false;

        if (a.val != b.val) return false;

        return isSubStructure_helper(a.left, b.left) && isSubStructure_helper(a.right, b.right);
    }

    /*
     * 剑指 Offer 31. 栈的压入、弹出序列
     * */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;

        Stack<Integer> stack = new Stack<>();

        int i = 0, j = 0;

        while (i < popped.length) {

            stack.push(pushed[i]);
            i++;

            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
    }

    /*
     * 剑指 Offer 46. 把数字翻译成字符串
     * */
    public int translateNum(int num) {
        String c = num + "";
        if (c.length() <= 1) return c.length();

        int[] dp = new int[c.length()];

        dp[0] = 1;
        String dp1 = c.substring(0, 2);
        dp[1] = (dp1.compareTo("10") >= 0 && dp1.compareTo("25") <= 0) ? 2 : 1;
        if (c.length() == 2) return dp[1];


        for (int i = 2; i < c.length(); i++) {
            String temp = c.substring(i - 1, i + 1);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }

        return dp[c.length() - 1];

    }

    /*
     * 硬 剑指 Offer 38. 字符串的排列
     * */
    public String[] _permutation(String s) {
        Set<String> res = new HashSet<>();
        _permutation_helper("", s, res);
        return res.toArray(new String[]{});
    }

    public void _permutation_helper(String prefix, String suffix, Set<String> set) {
        if (suffix.length() == 0) set.add(prefix);

        for (int i = 0; i < suffix.length(); i++) {
            StringBuilder sb = new StringBuilder(suffix);
            _permutation_helper(prefix + sb.charAt(i), sb.deleteCharAt(i).toString(), set);
        }

    }

    /*
     * dfs 剑指 Offer 38. 字符串的排列
     * */
    public String[] __permutation(String s) {
        HashSet<String> res = new HashSet<>();
        boolean[] visited = new boolean[s.length()];

        __permutation_helper(new char[s.length()], 0, s, visited, res);

        return res.toArray(new String[]{});

    }

    public void __permutation_helper(char[] s, int len, String str, boolean[] visited, HashSet<String> list) {
        if (len >= str.length()) {
            list.add(String.valueOf(s));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            s[len] = str.charAt(i);
            if (!visited[i]) {
                visited[i] = true;
                __permutation_helper(s, ++len, str, visited, list);
                visited[i] = false;
                len--;
            }
        }

    }

    /*
     * 硬 剑指 Offer 38. 字符串的排列
     * */
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        permutation_dfs(0, s.toCharArray(), res);
        return res.toArray(new String[]{});
    }

    public void permutation_dfs(int len, char[] str, List<String> list) {
        if (len == str.length) {
            list.add(String.valueOf(str));
            return;
        }

        for (int i = len; i < str.length; i++) {
            boolean flag = false;

            for (int j = len; j < i; j++) {
                if (str[i] == str[j]) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue;

            permutation_swap(str, len, i);
            permutation_dfs(len + 1, str, list);
            permutation_swap(str, len, i);

        }

    }

    public void permutation_swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    /*
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * */
    public boolean _verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) return true;

        List<Integer> li = new ArrayList<>();
        for (int i = postorder.length - 1; i >= 0; i--) li.add(postorder[i]);

        return _verifyPostorder_helper(li, Integer.MAX_VALUE, Integer.MIN_VALUE);

    }

    public boolean _verifyPostorder_helper(List<Integer> li, int max, int min) {
        int mid = li.remove(0);

        if (mid > max || mid < min) return false;

        if (li.isEmpty()) return true;

        if (mid > li.get(0)) return _verifyPostorder_helper(li, mid, min);

        for (int i = 0; i < li.size(); i++)
            if (mid > li.get(i)) return _verifyPostorder_helper(li.subList(i, li.size()), mid, min)
                    && _verifyPostorder_helper(li.subList(0, i), max, mid);

        return _verifyPostorder_helper(li, max, mid);

    }

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder_helper(postorder, 0, postorder.length - 1);

    }

    public boolean verifyPostorder_helper(int[] li, int start, int end) {
        if (start >= end) return true;
        int p = start;
        while (li[p] < li[end]) p++;
        int mid = p;
        while (li[p] > li[end]) p++;
        return p == end && verifyPostorder_helper(li, start, mid - 1) && verifyPostorder_helper(li, mid, end - 1);
    }

    /*
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new LinkedList<>();
        pathSun_dfs(root, res, new LinkedList<>(), 0, target);
        return res;
    }

    public void pathSun_dfs(TreeNode root, List<List<Integer>> paths, LinkedList<Integer> path, int total, int target) {
        // 出口
        if (root == null) return;

        total += root.val;
        path.add(root.val);

        if (total == target && root.left == null && root.right == null) {
            paths.add(new LinkedList<>(path));
        }

        pathSun_dfs(root.left, paths, path, total, target);
        pathSun_dfs(root.right, paths, path, total, target);

        path.removeLast();
    }

    public static void main(String[] args) {

        Offer offer = new Offer();

        TreeNode tree = TreeNode.createTree(new LinkedList<>(Arrays.asList(-2, null, -3)));

        List<List<Integer>> lists = offer.pathSum(tree, -5);

        System.out.println(lists);
    }


}
