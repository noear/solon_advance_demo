package demo.controller.gateway.interceptor;

import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

/**
 * @author noear 2021/2/11 created
 */
public class OutputHandler implements Handler {
    @Override
    public void handle(Context c) throws Throwable {
        if (c.result != null) {
            String json = (String) c.result;

            c.outputAsJson(json);
        }
    }
}
