package com.lixl.mybatis.demo.disruptor.process;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public abstract class BaseEventProcessor<T> implements EventHandler<T>, WorkHandler<T> {

    @Override
    public void onEvent(T dataStream, long sequence, boolean endOfBatch) throws Exception {
        try {
            this.onEvent(dataStream);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public abstract void onEvent(T dataStream) throws Exception;
}