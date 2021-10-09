package cn.codinglemon.demo.dao;

import cn.codinglemon.demo.entity.Stock;
import org.apache.ibatis.annotations.Param;

/**
 * @author zry
 * @date 2021-9-29 16:30
 */
public interface StockDao {

    Stock selectById(@Param("id")Integer id);

    int sale(@Param("id")Integer id,@Param("sale")Integer sale,@Param("version")Integer version);
}
