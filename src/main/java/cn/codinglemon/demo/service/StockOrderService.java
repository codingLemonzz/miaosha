package cn.codinglemon.demo.service;

import cn.codinglemon.demo.Response.ResponseBean;
import cn.codinglemon.demo.entity.StockOrder;

/**
 * @author zry
 * @date 2021-9-29 18:48
 */
public interface StockOrderService {

    ResponseBean createOrder(StockOrder stockOrder);

}
