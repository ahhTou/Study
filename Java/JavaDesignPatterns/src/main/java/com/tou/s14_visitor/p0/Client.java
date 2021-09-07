package com.tou.s14_visitor.p0;

import com.tou.s14_visitor.p0.visitor.Action;
import com.tou.s14_visitor.p0.visitor.Wait;
import com.tou.s14_visitor.p0.element.Man;
import com.tou.s14_visitor.p0.element.Woman;

public class Client {

    public static void main(String[] args) {
        // 创建ObjectStructure
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        Action success = new Wait();
        objectStructure.display(success);
    }

}
