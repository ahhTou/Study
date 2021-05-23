import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import utils.TreeNode;

import java.util.*;

// @RunWith(Parameterized.class)
public class MyTest {

    public static void main(String[] args) {

        new Son() {{
            say(3);
        }};

    }

}

class Son extends Father {

    public Son() {
        super();
        System.out.println("儿子初始化了");
        say(2);
    }

    @Override
    public void say(int i) {
        System.out.println("我是儿子 " + i);
    }

}

class Father {
    public Father() {
        System.out.println("父亲初始化了");
        say(1);
    }

    public void say(int i) {
        System.out.println("我是父亲 " + i);
    }
}