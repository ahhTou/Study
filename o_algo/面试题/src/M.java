import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import utils.ListNode;
import utils.TreeNode;

import java.util.*;

public class M {
    /*
     * 01. 判断字符串是否唯一
     * */
    public boolean isUnique(String astr) {
        int[] hash = new int[26];
        for (char ch : astr.toCharArray()) {
            hash[ch - 'a']++;
            if (hash[ch - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    /*
     * 面试题 01.02. 判定是否互为字符重排
     * */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        StringBuilder sb = new StringBuilder(s1);

        for (int i = 0; i < s2.length(); i++) {
            int index = sb.indexOf(String.valueOf(s2.charAt(i)));
            if (index == -1) return false;
            sb.deleteCharAt(index);
        }

        return true;
    }

    /*
     * 面试题 01.03. URL化
     * */
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int trueLen = length;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') trueLen += 2;
        }

        char[] res = new char[trueLen];
        int j = trueLen - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                res[j--] = '0';
                res[j--] = '2';
                res[j--] = '%';
            } else {
                res[j--] = chars[i];
            }
        }
        return String.valueOf(res);
    }

    /*
     * 面试题 01.04. 回文排列
     * */
    public boolean canPermutePalindrome(String s) {
        int num = 0;
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                num--;
                set.remove(c);
            } else {
                num++;
                set.add(c);
            }
        }
        return num == (s.length() % 2 == 0 ? 0 : 1);
    }


    /*
     * 面试题 01.05. 一次编辑
     * */
    public boolean oneEditAway(String first, String second) {

        if (first.equals(second)) return true;

        if (second.length() > first.length()) {
            String temp = first;
            first = second;
            second = temp;
        }

        int len1 = first.length();
        int len2 = second.length();

        if (len1 - len2 > 1) return false;
        if (len2 == 0) return len1 == 1 || len1 == 0;

        boolean flag = len1 == len2;

        int j = 0, diff = 0;

        char[] str1 = first.toCharArray();
        char[] str2 = second.toCharArray();

        for (int i = 0; i < len1; i++) {
            if (str1[i] != str2[j]) {
                if (diff > 0) return false;
                diff++;
                if (flag) j++;
            } else j++;

            if (j == len2) return true;

        }
        return true;
    }

    /*
     * 面试题 01.06. 字符串压缩
     * */
    public String compressString(String S) {

        int len = S.length();
        if (len == 0) return "";
        char[] chars = S.toCharArray();

        StringBuilder res = new StringBuilder();

        int temp = 0;
        char tChar = chars[0];
        for (int i = 0; i < len; i++) {
            if (tChar == chars[i]) {
                temp++;
            } else {
                res.append(tChar).append(temp);
                temp = 1;
            }
            tChar = chars[i];
        }
        res.append(tChar).append(temp);

        return res.length() < chars.length ? res.toString() : new String(chars);

    }


    /*
     *
     * 面试题 01.07. 旋转矩阵
     * */
    public void rotate(int[][] matrix) {
        int temp;
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }

    }

    /*
     * 面试题 01.08. 零矩阵
     * */
    public void setZeroes(int[][] matrix) {
        Set<Integer> y = new HashSet<>();
        Set<Integer> x = new HashSet<>();

        int h = matrix.length;
        int w = matrix[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println("命中");
                    y.add(i);
                    x.add(j);
                }
            }
        }

        for (int i : x) {
            for (int j = 0; j < h; j++) {
                matrix[j][i] = 0;
            }
        }

        for (int i : y) {
            for (int j = 0; j < w; j++) {
                matrix[i][j] = 0;
            }
        }


    }

    /*
     * 面试题 01.09. 字符串轮转
     * */
    public boolean isFlipedString(String s1, String s2) {
        /*
         *  if (s1.length()!=s2.length()) return false;
         * String ss = s2+s2;
         * return ss.contains(s1);
         * }
         *
         * */
        int len1 = s1.length(), len2 = s2.length(), i = 0, j = 0, shut = 0;
        if (len1 != len2) return false;
        if (len1 == 0) return true;

        boolean flag = false;
        while (i < len1) {
            if (s1.charAt(i) != s2.charAt(j)) {
                i = shut = 0;
            } else {
                i = i == len1 - 1 ? 0 : i + 1;
                shut++;
                if (shut == len1) return true;
            }
            j++;
            if (j == len1) {
                if (flag) return false;
                flag = true;
                j = 0;
            }
        }

        return false;
    }

    /*
     * 面试题 02.01. 移除重复节点
     * */
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode v1 = head, temp, v2;
        while (v1 != null) {
            temp = v1;
            v2 = v1.next;
            while (v2 != null) {
                if (v2.val == v1.val) temp.next = v2.next;
                else temp = v2;
                v2 = v2.next;
            }
            v1 = v1.next;
        }
        return head;
    }

    /**
     * 快慢指针 面试题 02.02. 返回倒数第 k 个节点
     */
    public int kthToLast(ListNode head, int k) {
//        int size = 0;
//        ListNode v = head;
//        List<Integer> list = new ArrayList<>();
//        while (v != null) {
//            list.add(v.val);
//            v = v.next;
//            size++;
//        }
//        return list.get(size - k);
        ListNode fast = head;
        ListNode slow = head;

        while (k > 0) {
            fast = fast.next;
            k -= 1;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        assert slow != null;
        return slow.val;

    }

    /*
     * 面试题 02.03. 删除中间节点
     * */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /*
     * 面试题 02.04. 分割链表
     * */
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head, prev = head;
        while (cur != null) {
            if (cur.val < x) {
                int tmp = prev.val;
                prev.val = cur.val;
                cur.val = tmp;
                prev = prev.next;
            }
            cur = cur.next;
        }
        return head;
    }

    /*
     * 面试题 02.05. 链表求和
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int up = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int num = num1 + num2 + up;
            up = num / 10;

            cur.next = new ListNode(num % 10);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if (up == 1)
            cur.next = new ListNode(up);

        return res.next;
    }

    /**
     * 递归 or 快慢指针 面试题 02.06. 回文链表
     */
    private ListNode root = null;

    public boolean isPalindrome(ListNode head) {
        root = head;
        return dfs4isPalindrome(head);
    }

    public boolean dfs4isPalindrome(ListNode cur) {
        if (cur == null) return true;
        if (dfs4isPalindrome(cur.next)) {
            if (cur.val != root.val) return false;
            root = root.next;
        } else return false;
        return true;
    }

    /*
     * 面试题 02.07. 链表相交
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode h1 = headA, h2 = headB;

        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }

    /*
     * 面试题 02.08. 环路检测
     * */
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode v = head;
        while (v != null) {
            int size = set.size();
            set.add(v);
            if (size == set.size()) return v;
            v = v.next;
        }

        return head;
    }

    /*
     * 面试题 04.02. 最小高度树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST_helper(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST_helper(int[] nums, int i, int j) {
        if (j == 0 || i == j) return new TreeNode(nums[j]);

        int mid = ((i + j) % 2 == 0) ? ((i + j) / 2) : ((i + j) / 2 + 1);

        TreeNode res = new TreeNode(nums[mid]);

        if (j - i == 1) {
            res.left = new TreeNode(nums[i]);
        } else if (j - i == 2) {
            res.right = new TreeNode(nums[mid + 1]);
            res.left = new TreeNode(nums[mid - 1]);
        } else {
            res.left = sortedArrayToBST_helper(nums, i, mid - 1);
            res.right = sortedArrayToBST_helper(nums, mid + 1, j);
        }

        return res;
    }

    /*
     * 面试题 04.03. 特定深度节点链表
     * */
    public ListNode[] listOfDepth(TreeNode tree) {
        List<TreeNode> tree_arr = new LinkedList<>();
        List<ListNode> res = new LinkedList<>();
        tree_arr.add(tree);

        while (!tree_arr.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();
            for (TreeNode a_tree : tree_arr) {
                if (a_tree.left != null) temp.add(a_tree.left);
                if (a_tree.right != null) temp.add(a_tree.right);
            }
            res.add(listOfDepth_helper(tree_arr));
            tree_arr = temp;
        }

        return res.toArray(new ListNode[0]);
    }

    public ListNode listOfDepth_helper(List<TreeNode> list) {
        if (list.isEmpty()) return null;
        ListNode res = new ListNode(list.remove(0).val);
        res.next = listOfDepth_helper(list);
        return res;
    }

    /*
     * 面试题 04.04. 检查平衡性
     * */
    public boolean isBalanced(TreeNode root) {
        int res = isBalanced_helper(root);
        System.out.println(res);
        return res != -1;
/*        if (root == null) return true;

        int l = isBalanced_helper(root.left);
        System.out.println("final l is " + l);
        if (l == -1) return false;

        int r = isBalanced_helper(root.right);
        System.out.println("final r is " + r);
        if (r == -1) return false;

        return Math.abs(r - l) < 2;*/
    }

    public int isBalanced_helper(TreeNode tree) {
        if (tree == null) return 1;

        int r = isBalanced_helper(tree.right);

        if (r == -1) return -1;

        int l = isBalanced_helper(tree.left);

        if (l == -1) return -1;

        if (Math.abs(r - l) >= 2) return -1;

        return Math.max(r, l) + 1;
    }


    /*
     * 面试题 04.05. 合法二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST_helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST_helper(TreeNode root, long min, long max) {
        if (root == null) return true;

        return (root.val > min && root.val < max)
                && isValidBST_helper(root.right, root.val, max)
                && isValidBST_helper(root.left, min, root.val);
    }

    /*
     * 面试题 04.06. 后继者
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;


        TreeNode left_res = inorderSuccessor(root.left, p);
        if (left_res != null) return left_res;

        if (p.val < root.val) return root;

        return inorderSuccessor(root.right, p);
    }

    /*
     * 面试题 04.08. 首个共同祖先
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        if (left != null && right != null) return root;

        if (left != null) return left;

        return right;
    }

    /**
     * 面试题 08.01. 三步问题
     */
    public int waysToStep(int n) {

        int[] dp = new int[n];
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i < n; i++)
            dp[i] = ((dp[i - 3] + dp[i - 2]) % 1000000007 + dp[i - 1]) % 1000000007;

        return dp[n - 1];
    }

    /**
     * 面试题 08.02. 迷路的机器人
     */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        pathWithObstacles_helper(0, 0, obstacleGrid, res);
        return res;
    }

    public boolean pathWithObstacles_helper(int x, int y, int[][] map, List<List<Integer>> now) {
        int m = map.length - 1;
        int n = map[0].length - 1;

        if (map[x][y] == 1) return false;

        now.add(Arrays.asList(x, y));

        if (x == m && y == n) return true;

        if ((x <= m && pathWithObstacles_helper(x + 1, y, map, now))
                || (y <= n && pathWithObstacles_helper(x, y + 1, map, now))) return true;

        now.remove(now.size() - 1);

        map[x][y] = 1;

        return false;

    }

    /**
     * 面试题 08.10. 颜色填充
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] visitor = new int[image.length][image[0].length];
        floodFill_helper(image, sr, sc, visitor, image[sr][sc], newColor);
        return image;
    }

    public void floodFill_helper(int[][] image, int sr, int sc, int[][] visitor, int targetColor, int newColor) {
        visitor[sr][sc] = 1;
        if (image[sr][sc] == targetColor) {
            image[sr][sc] = newColor;
        } else return;

        int m = image.length, n = image[0].length;

        if (sr + 1 < m && visitor[sr + 1][sc] != 1)
            floodFill_helper(image, sr + 1, sc, visitor, targetColor, newColor);
        if (sr - 1 >= 0 && visitor[sr - 1][sc] != 1)
            floodFill_helper(image, sr - 1, sc, visitor, targetColor, newColor);
        if (sc + 1 < n && visitor[sr][sc + 1] != 1)
            floodFill_helper(image, sr, sc + 1, visitor, targetColor, newColor);
        if (sc - 1 >= 0 && visitor[sr][sc - 1] != 1)
            floodFill_helper(image, sr, sc - 1, visitor, targetColor, newColor);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new M().floodFill(new int[][]{
                new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}
        }, 1, 1, 2)));
    }

}
