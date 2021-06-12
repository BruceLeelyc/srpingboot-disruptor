package com.lixl.mybatis.demo.pojo.dto;

import lombok.Data;

/**
 * @ClassName: DomainBeanDataStream
 * @Description:
 * @Author: lixl
 * @Date: 2021/6/12 15:42
 */
@Data
public class BeanDataParam {

    private String flag;

    private BaseBean param;

    private int expire;
}
