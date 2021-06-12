package com.lixl.mybatis.demo.disruptor;

import com.lmax.disruptor.*;

import java.util.concurrent.TimeUnit;

public enum WaitStrategyType {

    BLOCKING {
        public WaitStrategy instance() {
            return new BlockingWaitStrategy();
        }
    },

    BUSY_SPIN {
        public WaitStrategy instance() {
            return new BusySpinWaitStrategy();
        }
    },

    LITE_BLOCKING {
        public WaitStrategy instance() {
            return new LiteBlockingWaitStrategy();
        }
    },

    SLEEPING_WAIT {
        public WaitStrategy instance() {
            return new SleepingWaitStrategy();
        }
    },

    YIELDING {
        public WaitStrategy instance() {
            return new YieldingWaitStrategy();
        }
    },

    TIMEOUT_BLOCKING_WAIT {
        public WaitStrategy instance() {
            return new TimeoutBlockingWaitStrategy(3000, TimeUnit.MILLISECONDS);
        }
    },

    LITE_TIMEOUT_BLOCKING_WAIT {
        public WaitStrategy instance() {
            return new LiteTimeoutBlockingWaitStrategy(3000, TimeUnit.MILLISECONDS);
        }
    },
    PHASED_BACK_OFF_WAIT {
        public WaitStrategy instance() {
            return PhasedBackoffWaitStrategy.withLiteLock(1500, 3000, TimeUnit.NANOSECONDS);
        }
    };

    public abstract WaitStrategy instance();
}
