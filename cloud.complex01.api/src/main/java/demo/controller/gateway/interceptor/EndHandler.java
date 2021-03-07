package demo.controller.gateway.interceptor;

import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author noear 2021/2/10 created
 */
public class EndHandler implements Handler {
    static Logger log = LoggerFactory.getLogger(EndHandler.class);

    @Override
    public void handle(Context c) throws Throwable {
        long _start = c.attr("_start", 0L);
        long _timespan = System.currentTimeMillis() - _start;

        //记录接口用时


        //记录接口输入输出日志
        if (c.result != null) {
            MDC.put("tag0", c.pathNew());
            log.info("\ni:: {}\no:: {}", c.paramMap(), c.result);
        }

        //记录异常
        if (c.errors != null) {
            MDC.put("tag0", c.pathNew());
            log.error("\ni:: {}\no:: {}", c.paramMap(), c.errors);
        }
    }
}
