package com.lixl.mybatis.demo.disruptor.process;

import com.lixl.mybatis.demo.pojo.User;
import com.lixl.mybatis.demo.pojo.dto.BeanDataParam;
import com.lixl.mybatis.demo.service.UserService;
import com.lixl.mybatis.demo.utils.ApplicationContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: Demo2EventProcessor
 * @author: lixl
 * @Date: 2021/5/12 15:48
 */
public class Demo2EventProcessor extends BaseEventProcessor<BeanDataParam> {

    private static final Logger logger = LoggerFactory.getLogger(Demo2EventProcessor.class);

    @Override
    public void onEvent(BeanDataParam dataStream, long l, boolean b) throws Exception {
        logger.info("receive message");
        super.onEvent(dataStream, l, b);
    }

    @Override
    public void onEvent(BeanDataParam dataStream) throws Exception {
        logger.info("event key:{}, class:{}", dataStream.getFlag(), dataStream.getParam().getClass().getName());
        UserService userService = ApplicationContextUtil.getBean(UserService.class);
        User user = userService.findById(2L);
        logger.info(user.toString());
    }
}
