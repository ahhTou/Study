import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import utils.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// @RunWith(Parameterized.class)
public class MyTest {

    Offer offer = new Offer();

    int[] a;
    int res;
    boolean flag;

/*    public MyTest(int[] a, int res) {
        this.a = a;
        this.res = res;
    }*/

    @Test
    public void voidMaxDepth() {
        Deque<Integer> deque = new LinkedList<>(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        TreeNode root = TreeNode.createTree(deque);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(offer.lowestCommonAncestor(root, p, q).val);
    }


    // @Parameters
/*
    public static Object[] testMissingNumberParameters() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, true},
        };
    }
*/

}
