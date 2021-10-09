package cn.codinglemon.demo.entity;

import lombok.Data;

/**
 * @author zry
 * @date 2021-9-29 16:28
 */
@Data
public class Stock {

    private Integer id;
    private String name;
    private Integer count;
    private Integer sale;
    //这里的价格使用long字段来表示，price的值等于商品输入价格*10，以此来解决计算机浮点数计算精度问题
    private long price;
    private Integer version;
}
