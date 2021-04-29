package com.tou.s00_principle.s5_ocp.improve;

public class OcpPro {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }
}

/**
 * 用于绘图的类 [ 使用方 ] （ 不应该修改 ）
 * 优点：
 * 1. 比较好理解，简单操作
 * 存在的问题：
 * 1. 违反 ocp 原则
 */
class GraphicEditor {
    // 接受Shape 对象，然后根据type 绘制不同的图形
    public void drawShape(Shape s) {
        s.draw();
    }
}

/**
 * shape 基类
 */
abstract class Shape {
    int m_type;

    public abstract void draw(); //抽象方法
}


class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("口");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("⚪");
    }
}

class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println("▲");
    }
}

class OtherGraphic extends Shape {
    OtherGraphic() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        System.out.println("X");
    }
}
