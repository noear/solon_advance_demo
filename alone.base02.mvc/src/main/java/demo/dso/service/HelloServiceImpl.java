package demo.dso.service;

import org.noear.solon.annotation.ProxyComponent;

/**
 * @author noear 2021/2/8 created
 */
@ProxyComponent
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
