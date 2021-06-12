package com.lixl.mybatis.demo.disruptor;

import com.lmax.disruptor.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataEventHandlerException implements ExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(DataEventHandlerException.class);
    @Override
    public void handleEventException(Throwable throwable, long sequence, Object event) {
        logger.error("handle error stack:{}, sequence:{}, data:{}", throwable.fillInStackTrace(), sequence, event);
        throwable.fillInStackTrace();
    }

    @Override
    public void handleOnStartException(Throwable throwable) {
        logger.error("disruptor start error:{},meseage:{}", throwable.fillInStackTrace(), throwable.getMessage());
    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {
        logger.error("disruptor shutdown error:{},meseage:{}", throwable.fillInStackTrace(), throwable.getMessage());
    }
}
