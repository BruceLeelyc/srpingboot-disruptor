package com.lixl.mybatis.demo.disruptor.demo;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @ClassName: LongEventHandler
 * @Description:
 * @Author: lixl
 * @Date: 2021/6/12 14:31
 */
public class LongEventHandler2 implements EventHandler<LongEvent>, WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("LongEventHandler2="+longEvent.getValue());
    }

    @Override
    public void onEvent(LongEvent longEvent) throws Exception {
        System.out.println("LongEventHandler2.work="+longEvent.getValue());
    }
}
