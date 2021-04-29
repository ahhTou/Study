package com.tou.s00_principle.s5_ocp;

public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawRectangle(new Rectangle());
        graphicEditor.drawRectangle(new Circle());
        graphicEditor.drawRectangle(new Triangle());
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
        if (s.m_type == 1) drawRectangle(s);
        else if (s.m_type == 2) drawCircle(s);
        else if (s.m_type == 3) drawTriangle(s);
    }

    public void drawRectangle(Shape r) {
        System.out.println("绘制矩形");
    }

    public void drawCircle(Shape r) {
        System.out.println("绘制圆形");
    }

    public void drawTriangle(Shape r) {
        System.out.println("绘制三角形");
    }
}

/**
 * shape 基类
 */
class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}

class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}
