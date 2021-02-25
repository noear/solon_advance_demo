package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2021/2/25 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(HelloApp.class)
public class HelloTest extends HttpTestBase {
    @Test
    public void test() throws Exception {
        assert path("/hello").get().equals("hello world!");
    }
}
