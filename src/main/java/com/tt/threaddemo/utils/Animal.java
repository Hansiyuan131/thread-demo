package com.tt.threaddemo.utils;

/**
 * 抽象类
 * 1. 可以定义构造函数
 * 2. 可以有抽象方法和具体方法
 * 3. 抽象类中的成员可以是 private、默认、 protected、 public
 * 4. 抽象类中可以定义成员变量
 * 5. 有抽象方法的类必须被声明为抽象类，而抽象类未必要有抽象方法
 * 6. 抽象类中可以包含静态方法
 * 7. 一个类只能继承一个抽象类
 *
 * @author hansiyuan
 * @date 2021年06月16日 20:44
 */
public abstract class Animal {

    /**
     * 可以定义构造函数
     */
    public Animal() {

    }

    /**
     * 吃
     */
    public abstract void eat();

    /**
     * 可以定义带实体的方法
     */
    public static void run() {
        System.out.println("我会运动");
    }

    private String aaa;
}
