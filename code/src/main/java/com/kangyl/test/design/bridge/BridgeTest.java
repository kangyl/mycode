package com.kangyl.test.design.bridge;

/**
 * 桥接模式测试
 * 桥接模式将 继承改为组合(组合或聚合),将抽象与实现脱耦，数据库驱动即为桥接模式
 * 优点:
 * 分离抽象接口和实现部分
 * 桥接模式类似多继承方案，但是比多继承方案好，因为多继承方案违背了单一职责原则。
 * 桥接模式提高了系统的可扩充性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统。
 * 实现细节对客户透明，可以对用户隐藏实现细节。
 * 缺点：
 * 桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计与编程。
 * 桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用范围具有一定的局限性。
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/28
 */
public class BridgeTest {

    public static void main(String[] args) {
        Pencil pencil = new SuperPencil();
        Color color = new RedColor();
        pencil.setColor(color);
        pencil.draw();
    }
}
