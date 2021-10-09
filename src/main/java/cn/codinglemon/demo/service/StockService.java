package cn.codinglemon.demo.service;

import cn.codinglemon.demo.entity.Stock;

/**
 * @author zry
 * @date 2021-9-29 18:39
 */
public interface StockService {

    boolean checkStock(Integer id,Integer count);

    Stock selectById(Integer id);
}
