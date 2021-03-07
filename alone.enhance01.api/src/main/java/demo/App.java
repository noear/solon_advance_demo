package demo;

import org.noear.solon.Solon;
import org.noear.solon.core.handle.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author noear 2021/2/10 created
 */
public class App {
    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {


        Solon.start(App.class, args).onError(err -> {
            Context ctx = Context.current();

            if (ctx == null) {
                logger.error("{}", err);
            } else {
                MDC.put("tag0", ctx.path());
                logger.error("{}", err);
            }
        });
    }
}
