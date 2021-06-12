package com.lixl.mybatis.demo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SystTable
 * @Description:
 * @Author: lixl
 * @Date: 2021/6/10 21:18
 */
@Data
public class SysTable implements Serializable {
    private static final long serialVersionUID = 3374510519884523211L;

    private String variable;
    private String value;
    private String setBy;
}
