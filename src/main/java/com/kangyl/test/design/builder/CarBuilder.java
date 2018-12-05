package com.kangyl.test.design.builder;

import java.util.List;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年12月05日
 */
public interface CarBuilder {

    void setPart(List<String> parts);

    Car buildCar();
}
