package com.lixl.mybatis.demo.disruptor.demo;

/**
 * @ClassName: LongEvent
 * @Description:
 * @Author: lixl
 * @Date: 2021/6/12 14:30
 */
public class LongEvent {
    private long value;
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
