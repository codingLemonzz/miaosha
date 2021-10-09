package cn.codinglemon.demo.controller;

import cn.codinglemon.demo.Response.StockResponseEnum;
import cn.codinglemon.demo.entity.Stock;
import cn.codinglemon.demo.entity.StockOrder;
import cn.codinglemon.demo.service.StockOrderService;
import cn.codinglemon.demo.service.StockService;
import cn.codinglemon.demo.Response.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zry
 * @date 2021-9-29 16:42
 */
@RestController
@CrossOrigin
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockOrderService stockOrderService;

    @GetMapping("/kill")
    public ResponseBean kill(@RequestParam("id") Integer id, @RequestParam("count") Integer count) {
        ResponseBean responseBean;
        Stock stock = stockService.selectById(id);
        StockOrder stockOrder = new StockOrder();
        stockOrder.setName(stock.getName());
        stockOrder.setSid(stock.getId());
        stockOrder.setTotalPrice(count * stock.getPrice());
        stockOrder.setCount(count);
        responseBean = stockOrderService.createOrder(stockOrder);
        return responseBean;
    }
}
