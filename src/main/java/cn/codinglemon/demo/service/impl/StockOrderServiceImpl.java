package cn.codinglemon.demo.service.impl;

import cn.codinglemon.demo.Response.ResponseBean;
import cn.codinglemon.demo.Response.StockResponseEnum;
import cn.codinglemon.demo.dao.StockDao;
import cn.codinglemon.demo.dao.StockOrderDao;
import cn.codinglemon.demo.entity.Stock;
import cn.codinglemon.demo.entity.StockOrder;
import cn.codinglemon.demo.service.StockOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zry
 * @date 2021-9-29 18:49
 */
@Service
public class StockOrderServiceImpl implements StockOrderService {

    @Autowired
    private StockOrderDao stockOrderDao;

    @Autowired
    private StockDao stockDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseBean createOrder(StockOrder stockOrder) {

        ResponseBean responseBean = new ResponseBean();

        Stock stock = stockDao.selectById(stockOrder.getSid());
        //查看能否找到商品
        if( stock != null){
            //检查库存是否足够
            if(stock.getCount() >= stock.getSale() + stockOrder.getCount()){
                boolean changeStock = stockDao.sale(stockOrder.getSid(),stockOrder.getCount()+stock.getSale(),stock.getVersion()) > 0;
                //判断更新库存成功
                if(changeStock){
                    boolean result = stockOrderDao.createOrder(stockOrder) >0;
                    //判断订单是否成功存入数据库
                    if(result){
                        responseBean.setCode(StockResponseEnum.STOCK_SUCCESS.getCode());
                        responseBean.setMsg(StockResponseEnum.STOCK_SUCCESS.getMessage());
                        responseBean.setData(stockOrder);
                    }
                }else {
                    //秒杀失败
                    responseBean.setCode(StockResponseEnum.KILL_FAIL.getCode());
                    responseBean.setMsg(StockResponseEnum.KILL_FAIL.getMessage());
                }
            }else {
                //库存不足
                responseBean.setCode(StockResponseEnum.STOCK_NOT_ENOUGH.getCode());
                responseBean.setMsg(StockResponseEnum.STOCK_NOT_ENOUGH.getMessage());
            }
        }else {
            //没有找到该商品库存
            responseBean.setCode(StockResponseEnum.NO_THIS_STOCK.getCode());
            responseBean.setMsg(StockResponseEnum.NO_THIS_STOCK.getMessage());
        }
        return responseBean;
    }
}
