package cn.codinglemon.demo.service.impl;

import cn.codinglemon.demo.dao.StockDao;
import cn.codinglemon.demo.entity.Stock;
import cn.codinglemon.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author zry
 * @date 2021-9-29 18:42
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;


    @Override
    public boolean checkStock(Integer id,Integer count) {
        Stock stock = stockDao.selectById(id);
        if(!ObjectUtils.isEmpty(stock)){
            //判断当前库存是否充足
            return stock.getCount() >= stock.getSale() + count;
        }
        return false;
    }

    @Override
    public Stock selectById(Integer id) {
        return stockDao.selectById(id);
    }
}
