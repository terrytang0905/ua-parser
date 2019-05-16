/** Created by zhenjietang at 8/22/2014 */
package com.newroad.common.device.util;

/**
 * 表示一个组合对象
 *
 * @author zhenjietang
 */
public class CompositeV1<T> {
    public final T first;

    public CompositeV1(T first) {
        this.first = first;
    }

    /** 判断此对象在逻辑上是否为null */
    public boolean isNull() {
        return ObjectUtils.isNullOrEmpty(first);
    }
}
