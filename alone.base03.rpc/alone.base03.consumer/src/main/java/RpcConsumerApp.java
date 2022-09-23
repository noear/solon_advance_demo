import controller.HelloTest;
import org.noear.solon.Solon;
import org.noear.solon.core.Aop;

/**
 * @author noear 2021/2/12 created
 */
public class RpcConsumerApp {
    public static void main(String[] args) {
        Solon.start(RpcConsumerApp.class, args);

        //通过Aop，从容器里获取
        HelloTest helloTest = Solon.context().getBean(HelloTest.class);
        helloTest.test();
    }
}
