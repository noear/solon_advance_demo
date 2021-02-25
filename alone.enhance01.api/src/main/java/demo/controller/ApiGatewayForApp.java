package demo.controller;

import demo.controller.gateway.interceptor.EndHandler;
import demo.controller.gateway.interceptor.OutputHandler;
import demo.controller.gateway.interceptor.StartHandler;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author noear 2021/2/10 created
 */
@Mapping("/api/v1/app/**")
@Controller
public class ApiGatewayForApp extends ApiGatewayBase {
    @Override
    protected void register() {
        before(StartHandler.class);

        after(OutputHandler.class);
        after(EndHandler.class);

        super.register();
    }
}
