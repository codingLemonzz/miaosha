package cn.codinglemon.demo.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zry
 * @date 2020-10-17 15:57:35
 * 返回给前台的数据对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseBean {
        private Integer code;
        private String msg;
        private Object data;
}
