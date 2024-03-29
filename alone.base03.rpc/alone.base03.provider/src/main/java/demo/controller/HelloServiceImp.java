package demo.controller;

import demo.HelloService;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;

/**
 * @author noear 2021/2/12 created
 */
@Mapping("")
@Remoting
public class HelloServiceImp implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
