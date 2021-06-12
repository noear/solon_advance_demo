package demo.controller.apis;

import demo.controller.ApiBase;
import demo.dso.service.ConfigService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.validation.annotation.NotEmpty;

/**
 * @author noear 2021/2/11 created
 */
@Component(tag = "api")
public class API_config_set extends ApiBase {

    @Inject
    ConfigService configService;

    @NotEmpty({"tag", "key"})
    @Mapping("config.set")
    public void exec(String tag, String key, String value) throws Throwable {
        //1.查找配置
        configService.setConfig(tag, key, value);
    }
}
