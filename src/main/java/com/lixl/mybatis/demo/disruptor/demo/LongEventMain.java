package com.lixl.mybatis.demo.disruptor.demo;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @ClassName: LongEventMain
 * @Description:
 * @Author: lixl
 * @Date: 2021/6/12 14:57
 */
public class LongEventMain {
    public static void main(String[] args) throws InterruptedException {
        // Executor that will be used to construct new threads for consumers
        Executor executor = Executors.newCachedThreadPool();
        ThreadFactory threadFactory = new ThreadPoolExecutorFactoryBean();

        // The factory for the event
        LongEventFactory factory = new LongEventFactory();
        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;
        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, executor);
        // Connect the handler
        disruptor.handleEventsWith(new LongEventHandler(), new LongEventHandler2());
        // Start the Disruptor, starts all threads running
        disruptor.start();
        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer buffer = ByteBuffer.allocate(8);
        for (long i = 0; i < 30; i++) {
            buffer.putLong(0, i);
            producer.onData(buffer);
            Thread.sleep(300);
        }
    }
}
