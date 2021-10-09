package cn.codinglemon.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zry
 * @date 2021-9-29 16:29
 */
@Data
public class StockOrder {
    private Integer id;
    private Integer sid;
    private String name;
    private Integer count;
    //这里的价格使用long字段来表示，totalPrice的值等于商品输入价格*10，以此来解决计算机浮点数计算精度问题
    private long totalPrice;
    private Date createTime;
}
