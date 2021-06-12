package com.lixl.mybatis.demo.disruptor;

import com.lixl.mybatis.demo.pojo.dto.BeanDataParam;
import com.lmax.disruptor.EventTranslator;

/**
 * @author hanxiaowei
 */
public class BeanDataParamTranslator implements EventTranslator<BeanDataParam> {

    private BeanDataParam data;

    public BeanDataParamTranslator(BeanDataParam data) {
        this.data = data;
    }

    @Override
    public void translateTo(BeanDataParam data, long sequence) {
        data.setFlag(this.data.getFlag());
        data.setParam(this.data.getParam());
        data.setExpire(this.data.getExpire());
    }
}
