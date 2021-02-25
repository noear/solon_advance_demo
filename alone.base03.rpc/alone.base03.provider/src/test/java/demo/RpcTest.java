package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2021/2/25 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(RpcProviderApp.class)
public class RpcTest extends HttpTestBase {

    @NamiClient(upstream = "http://localhost:8081")
    HelloService helloService;

    @Test
    public void test() {
        assert helloService.hello("noear").equals("Hello noear");
    }
}
