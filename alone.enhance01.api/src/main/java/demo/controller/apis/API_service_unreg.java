package demo.controller.apis;

import cn.hutool.crypto.SecureUtil;
import demo.controller.ApiBase;
import demo.dso.mapper.RegisterMapper;
import demo.dso.service.RegisterService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.validation.annotation.NotEmpty;
import org.noear.wood.annotation.Db;

/**
 * @author noear 2021/2/12 created
 */
@Component(tag = "api")
public class API_service_unreg extends ApiBase {

    @Inject
    RegisterService registerService;

    @NotEmpty({"service", "address"})
    @Mapping("service.unreg")
    public void exec(String service, String address) throws Throwable {

        String key = SecureUtil.md5(service + "#" + address);

        //1.删除注册的服务
        registerService.delService(service, key);
    }
}
