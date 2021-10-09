package cn.codinglemon.demo.dao;

import cn.codinglemon.demo.entity.StockOrder;

/**
 * @author zry
 * @date 2021-9-29 16:31
 */
public interface StockOrderDao {

    int createOrder(StockOrder stockOrder);
}
