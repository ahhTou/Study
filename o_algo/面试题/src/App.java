import utils.ListNode;

import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(
                Arrays.asList(1, 2, 2, 1)
        );
        System.out.println(solution.isPalindrome(node1));
    }
}
