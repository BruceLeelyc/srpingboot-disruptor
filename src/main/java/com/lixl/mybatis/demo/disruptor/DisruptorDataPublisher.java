package com.lixl.mybatis.demo.disruptor;

import com.lixl.mybatis.demo.disruptor.process.Demo1EventProcessor;
import com.lixl.mybatis.demo.disruptor.process.Demo2EventProcessor;
import com.lixl.mybatis.demo.disruptor.process.Demo3EventProcessor;
import com.lixl.mybatis.demo.pojo.dto.BeanDataParam;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @ClassName: HandpickDataStreamPublisher
 * @Description:
 * @Author: lixl
 * @Date: 2021/6/12 15:39
 */
@Service
public class DisruptorDataPublisher implements BaseEventPublisher<BeanDataParam>, DisposableBean, InitializingBean {
    private Disruptor<BeanDataParam> disruptor;

    private static final int RING_BUFFER_SIZE = 1024;

    private static final String THREADNAME = "DisruptorDataPublisher";

    private final WaitStrategyType waitStrategy = WaitStrategyType.BLOCKING;

    @Override
    public void destroy() throws Exception {
        disruptor.shutdown();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        disruptor = new Disruptor<BeanDataParam>(new BeanDataParamEvent(),RING_BUFFER_SIZE, new NamedThreadFactory(THREADNAME,true), ProducerType.MULTI, waitStrategy.instance());
        disruptor.setDefaultExceptionHandler(new DataEventHandlerException());
        disruptor.handleEventsWith(new Demo1EventProcessor(), new Demo2EventProcessor(), new Demo3EventProcessor());
        disruptor.start();
    }

    @Override
    public void publish(BeanDataParam param) {
        RingBuffer<BeanDataParam> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.publishEvent(new BeanDataParamTranslator(param));
    }
}
