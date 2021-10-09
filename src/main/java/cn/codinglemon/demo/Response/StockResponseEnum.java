package cn.codinglemon.demo.Response;

/**
 * @author zry
 * @date 2021-9-29 20:16
 */
public enum StockResponseEnum {

    STOCK_SUCCESS(20001,"下单商品成功"),
    STOCK_NOT_ENOUGH(20002,"商品库存不足"),
    KILL_FAIL(20003,"抢购失败"),
    NO_THIS_STOCK(20004,"没有该商品库存")

    ;

    StockResponseEnum(Integer code,String message) {
        this.code =code;
        this.message =message;
    }

    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public StockResponseEnum setMessage(String message) {
        this.message = message;
        return this;
    }
}
