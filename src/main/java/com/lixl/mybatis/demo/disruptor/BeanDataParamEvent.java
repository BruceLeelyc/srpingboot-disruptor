package com.lixl.mybatis.demo.disruptor;

import com.lixl.mybatis.demo.pojo.dto.BeanDataParam;
import com.lmax.disruptor.EventFactory;

/**
 * @ClassName: BeanDataParamEvent
 * @Description:
 * @Author: lixl
 * @Date: 2021/6/12 15:46
 */
public class BeanDataParamEvent implements EventFactory<BeanDataParam> {

    @Override
    public BeanDataParam newInstance() {
        return new BeanDataParam();
    }
}