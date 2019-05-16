/** Created by zhenjietang at 8/22/2014 */
package com.newroad.common.device.util;

/**
 * 表示一个组合对象
 *
 * @author zhenjietang
 */
public class CompositeV2<T, K> extends CompositeV1<T> {
    public final K second;

    public CompositeV2(T first, K second) {
        super(first);
        this.second = second;
    }

    public CompositeV2(CompositeV1<T> cv1, K second) {
        this(cv1.first, second);
    }

    @Override
    public boolean isNull() {
        return super.isNull() && ObjectUtils.isNullOrEmpty(second);
    }

    /** 返回其中的cv1对象 */
    public CompositeV1<T> cv1() {
        return new CompositeV1<>(first);
    }

    @Override
    public String toString() {
        return "CompositeV2{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        CompositeV2 that = (CompositeV2) o;

        if(first != null ? !first.equals(that.first) : that.first != null) return false;
        if(second != null ? !second.equals(that.second) : that.second != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
